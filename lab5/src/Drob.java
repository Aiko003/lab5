public class Drob {
    private int chislitel;   
    private int znamenatel; 
    public Drob(int chislitel, int znamenatel) {
        if (znamenatel == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.chislitel = chislitel;
        this.znamenatel = znamenatel;
        normalize(); // Нормализация дроби
    }

    private void normalize() {
        // Приведение дроби к стандартному виду
        if (znamenatel < 0) {
            chislitel = -chislitel;
            znamenatel = -znamenatel;
        }
        int gcd = gcd(Math.abs(chislitel), Math.abs(znamenatel));
        chislitel /= gcd;
        znamenatel /= gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }



    public void setchislitel(int chislitel) {
        this.chislitel = chislitel;
        normalize();
    }


    public void setznamenatel(int znamenatel) {
        if (znamenatel == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.znamenatel = znamenatel;
        normalize();
    }

    public double toDecimal() {
        return (double) chislitel / znamenatel;
    }

    public String toString() {
        return chislitel + "/" + znamenatel;
    }




    public int hashCode() {
        return 31 * chislitel + znamenatel;
    }
}
