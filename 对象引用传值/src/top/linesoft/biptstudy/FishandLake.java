package top.linesoft.biptstudy;

class Fish {
    int weight;
}

class Lake {
    Fish fish;

    void setFish(Fish s) {
        fish = s;
    }

    void eat(int n) {
        fish.weight = fish.weight + n;
    }
}

class FishandLake {
    public static void main(String[] args) {
        Fish niqiu = new Fish();
        System.out.println(niqiu.weight);//输出1
        Lake taihu = new Lake();
        Lake Xihu = new Lake();
        Lake Donghu = new Lake();

        taihu.setFish(niqiu);
        Xihu.setFish(niqiu);
        Donghu.setFish(niqiu);
        taihu.eat(15);
        System.out.println(niqiu.weight);//输出2
        System.out.println(taihu.fish.weight);//输出3
        System.out.println(Xihu.fish.weight);
        System.out.println(Donghu.fish.weight);
    }
}

