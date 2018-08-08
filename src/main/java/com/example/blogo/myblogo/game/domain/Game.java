package com.example.blogo.myblogo.game.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_game")
public class Game {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "playTimes")
    private Integer playTimes;
    @Column(name = "mixScore")
    private Integer mixScore;
    @Column(name = "gameName")
    private String gameName;

}
