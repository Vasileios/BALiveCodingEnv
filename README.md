# BALiveCodingEnv
Live Coding Environment

example

//run the drum Kit

BADrumKitEnv();

//checking buffers

MyEnvir.bufs[0];

====================================================DrumKit==============================================================

MyEnvir.metronomos.tempo_(1)//Set up metronome

//====================================================Track1==============================================================


//Play patterns

//Snare

~snare1 = Pbindef(\snare, \freq,60, \dur, 0.5, \amp, 1, \vol, 1,\shape,1,\buf, MyEnvir.bufs[3].postln, \pan, 0.4).play;

Do the same with other instruments:

~kick1 = Pbindef(\kick1, ...).play

~kick2 = Pbindef(\kick2, ...).play

~hihat1 = Pbindef(\hihat1, ...).play

~hihat2 = Pbindef(\hihat2, ...).play

...etc.

Have Fun!!


