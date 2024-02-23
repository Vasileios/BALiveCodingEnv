// =====================================================================
// SuperCollider Workspace - VA2024
// BADrumKit version II
// =====================================================================

KickEnvII {

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

	MyEnvir.kick2 = Pbindef(\kick2).fadeTime_(1);
		 fork{
			
			MyEnvir.metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
			MyEnvir.metronomos.schedAbs(MyEnvir.metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			MyEnvir.metronomos.tempo = 1;

			 MyEnvir.metronomos.tempo.postln;
			"metronomos->tempo = {MyEnvir.metronomos.tempo}".postln;


		MyEnvir.kick2 = Pbindef(\kick2, \buf, MyEnvir.bufs[1]);
			0.1.wait;
		MyEnvir.kick2 = Pbindef(\kick2, \dur, Pseq([0.25, 0.5, 0.5, 0,5], inf), \amp, 0.0000001);
			0.5.wait;

		MyEnvir.kick2 = Pbindef(\kick2, \instrument, \bf, \out, MyEnvir.mbus2).play(MyEnvir.metronomos, quant: 4);//or out 0//

	};


		"Pbindef(\\kick2) -> args: \\freq, \\dur, \\amp, \\pan".postln;

	}

}