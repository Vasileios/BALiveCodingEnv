// =====================================================================
// SuperCollider Workspace - VA2024
// BADrumKit version II
// =====================================================================

BassEnvI{

	classvar <>server, metronomos;
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

	MyEnvir.bass1 = Pbindef(\bass).fadeTime_(1);
		 fork{
					MyEnvir.metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
			MyEnvir.metronomos.schedAbs(MyEnvir.metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			MyEnvir.metronomos.tempo = 1;

			 MyEnvir.metronomos.tempo.postln;
			"metronomos->tempo = {MyEnvir.metronomos.tempo}".postln;

		MyEnvir.bass1 = Pbindef(\bass, \instrument, \bf, \out, MyEnvir.mbus9).play(MyEnvir.metronomos, quant: 4);

 MyEnvir.bass1 = Pbindef(\bass, \buf, MyEnvir.bufs2[0]);

MyEnvir.bass1 = Pbindef(\bass, \dur, Pseq([0.25, 0.5, 0, 0.5], inf), \amp, 0.0000001);

		


	};

		"Pbindef(\\bass) -> args: \\freq, \\dur, \\amp, \\pan".postcln;
		//name = n;
	}

}