// =====================================================================
// SuperCollider Workspace - VA2024
// BADrumKit version II
// =====================================================================

KickEnvI {

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

		
MyEnvir.kick1 =  Pbindef(\kick1).fadeTime_(1);

		 fork{
			
MyEnvir.metronomos = TempoClock(1);
			
// schedule an event at next whole beat
			

MyEnvir.metronomos.schedAbs(MyEnvir.metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });


MyEnvir.metronomos.tempo = 1;
			 MyEnvir.metronomos.tempo.postln;
			"metronomos->tempo = {MyEnvir.metronomos.tempo}".postln;

	

	
			 MyEnvir.kick1 =  Pbindef(\kick1,\buf, MyEnvir.bufs[0]);

			
			 			 MyEnvir.kick1 = Pbindef(\kick1, \freq, 120, \dur, Pseq([0.5, 0.5, 0.5, 0.5], inf), \amp, 0.0000001, \char, "kick_char".postln);


			 
		 MyEnvir.kick1 = Pbindef(\kick1, \instrument, \bf, \out, MyEnvir.mbus1).play(MyEnvir.metronomos, quant: 4);
			 


};

		"Pbindef(\\kick1) -> args: \\freq, \\dur, \\amp, \\pan...Filter Ndef(\\d1)".postln;
	}

}