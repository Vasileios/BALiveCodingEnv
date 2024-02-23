// =====================================================================
// SuperCollider Workspace - VA2024
// BADrumKit version II
// =====================================================================



HihatEnvI {

	classvar <>server;
	//classvar <>metronomos;
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


MyEnvir.hihat1 = Pbindef(\hihat1).fadeTime_(1);
	 fork{
			
		 	MyEnvir.metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
			MyEnvir.metronomos.schedAbs(MyEnvir.metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			MyEnvir.metronomos.tempo = 1;

			MyEnvir.metronomos.tempo.postln;
			"metronomos->tempo = {MyEnvir.metronomos.tempo}".postln;

	MyEnvir.hihat1 = Pbindef(\hihat1, \buf, MyEnvir.bufs[4]);
			0.1.wait;

MyEnvir.hihat1 = Pbindef(\hihat1, \freq, 630, \dur, Pseq([0.25, 0.25, 0.25, 0.25], inf), \amp, 0.0 );
		

			0.5.wait;

		MyEnvir.hihat1 = Pbindef(\hihat1, \instrument, \bf, \out, MyEnvir.mbus5).play(MyEnvir.metronomos, quant: 4);

		};

		"Pbindef(\\hihat1) -> args: \\freq, \\dur, \\amp, \\pan ...Filter Ndef(\\d5)".postln;
	}

}