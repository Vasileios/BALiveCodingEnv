VoiceEnvII{

	classvar <>server;
	var name;

	//Constructor

	*new{
		arg n;
		var obj;

		server = Server.local;
		obj = super.new;

		obj.init(n);

		//obj.initPattern;

		^obj;
	}

	init{ arg n;

	MyEnvir.voice2 = Pbindef(\voice2).fadeTime_(1);
		fork{

				MyEnvir.metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
			MyEnvir.metronomos.schedAbs(MyEnvir.metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			MyEnvir.metronomos.tempo = 1;

			MyEnvir.metronomos.tempo.postln;

		MyEnvir.voice2 = Pbindef(\voice2, \buf, MyEnvir.bufs4[2]);
0.1.wait;

		MyEnvir.voice2 = Pbindef(\voice2, \freq, 620, \dur, Pseq([0.5, 0.5, 0.5, 0.5], inf), \amp, 0.000001/*Prand([0.4, 0.3, 0.5, 0.36], inf)*/);

		//~t = TempoClock(4/4);

0.5.wait;

		MyEnvir.voice2 = Pbindef(\voice2, \instrument, \bf, \out, MyEnvir.mbus14).play(MyEnvir.metronomos, quant: 4);

};

		"Pbindef(\\voice3) -> args: \\freq, \\dur, \\amp, \\pan".postln;
	}

}