package step2.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(Rank.FIRST_PLACE, 2000000000),
    SECOND(Rank.SECOND_PLACE, 1500000),
    THIRD(Rank.THIRD_PLACE, 50000),
    FOURTH(Rank.FOURTH_PLACE, 5000),
    NONE(Rank.NONE_PLACE, 0);

    public static final int FIRST_PLACE = 6;
    public static final int SECOND_PLACE = 5;
    public static final int THIRD_PLACE = 4;
    public static final int FOURTH_PLACE = 3;
    public static final int NONE_PLACE = 0;

    private final int rank;
    private final int amount;

    Rank(int rank, int amount) {
        this.rank = rank;
        this.amount = amount;
    }

    public static Rank from(int rank) {
        return Arrays.stream(values())
                .filter(value -> rank == value.rank)
                .findFirst()
                .orElse(Rank.NONE);
    }

}