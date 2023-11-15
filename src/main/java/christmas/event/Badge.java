package christmas.event;

/*
    - 5천 원 미만: 없음
    - 5천 원 이상: 별
    - 1만 원 이상: 트리
    - 2만 원 이상: 산타
 */
public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private String name;
    private Integer threshold;

    Badge(String name, Integer threshold) {
        this.name = name;
        this.threshold = threshold;
    }

    public static Badge valueOf(Integer threshold) {
        for (Badge badge : Badge.values()) {
            if (badge.threshold > threshold)
                continue;
            return badge;
        }
        return NONE;
    }

    public String getName() {
        return name;
    }
}