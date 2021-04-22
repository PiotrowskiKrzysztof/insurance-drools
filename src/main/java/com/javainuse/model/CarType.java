package com.javainuse.model;

public enum CarType {
    SEGMENT_A(1.1),
    SEGMENT_B(1.2),
    SEGMENT_C(1.3),
    SEGMENT_D(1.4),
    SEGMENT_E(1.6), // executive cars
    SEGMENT_F(3.0), // limuzyny o najwyższym poziomie wyposażenia i najlepszych (często największych) silnikach
    SEGMENT_S(2.5), // sport coupes
    SEGMENT_H(1.5), // samochody ze składanym, twardym bądź miękkim dachem
    SEGMENT_J(1.8), // samochody prezentujące cechy umożliwiające jazdę w terenie
    SEGMENT_M(1.5); // klasa obszernych samochodów mogących zabrać przynajmniej 5 osób wraz z dużym bagażem

    double ratio;

    CarType(double ratio) {
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }
}