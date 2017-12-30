package com.brauner.advent.day20;

/**
 * Created by douglas on 29/12/2017.
 */
public class CollisionParticleSwarm extends ParticleSwarm {

    @Override
    void determineSolution() {
        for (int i = 0; i < 1000; i++) {
            for (Particle p : particles) {
                p.simulateTick();
            }


            for (int j = 0; j < particles.size(); j++) {
                boolean detect = false;
                for (int k = 0; k < particles.size(); k++) {
                    if (j != k && particles.get(j).equals(particles.get(k))) {
                        detect = true;
                        particles.remove(k);
                        k--;
                    }
                }
                if (detect) {
                    particles.remove(j);
                    j--;
                }
            }


        }
        System.out.println("Finished ticks and remained : " + particles.size());
    }
}
