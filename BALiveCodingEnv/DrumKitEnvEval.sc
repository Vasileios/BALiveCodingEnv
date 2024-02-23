// =====================================================================
// SuperCollider Workspace - VA2024
// BADrumKit version II
// =====================================================================


DrumKitEnvEval{



 	classvar <>server;
	var name;



	// Constructor

	*new{
		arg n;
		var obj;


		server = Server.local;
		obj = super.new;

		obj.init(n);



		^obj;
	}

	init{ arg n;




fork{
2.wait;
			

			KickEnvI();
			
			KickEnvII();
			
			SnareEnvI();
			
			HihatEnvI();
			
			HihatEnvII();
			
			BassEnvI();
			
			PadEnvI();
			
			VoiceEnvI();

			VoiceEnvII();


	0.5.wait;

	MyEnvir.syncDrums  = Ppar([MyEnvir.kick1, MyEnvir.kick2, MyEnvir.snare1, MyEnvir.hihat1, MyEnvir.hihat2, MyEnvir.bass1, MyEnvir.pad1, MyEnvir.voice1, MyEnvir.voice2]);


	0.1.wait;
	MyEnvir.syncDrums;
//server.sync;
};
	}


}