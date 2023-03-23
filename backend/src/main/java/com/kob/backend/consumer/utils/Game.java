package com.kob.backend.consumer.utils;

/**
 * @author Steven
 * @create 2023-03-23-9:18
 */
public class Game {
    private Integer rows;
    private Integer cols;
    private Integer inner_walls_count;
    int[][] g;

    public Game(Integer rows, Integer cols, Integer inner_walls_count) {
        this.rows = rows;
        this.cols = cols;
        this.inner_walls_count = inner_walls_count;
        this.g = new int[rows][cols];
    }
}
