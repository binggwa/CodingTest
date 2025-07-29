package Level1;

public class Level1_2 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health; // 최대 체력
        int currentHealth = health;
        int bandageTime = bandage[0];
        int healPerSecond = bandage[1];
        int bonusHeal = bandage[2];

        int time = 0; // 현재 시간
        int combo = 0; // 연속 성공 시간

        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int attackDamage = attack[1];

            // (time+1) ~ attackTime-1까지 회복
            while (time + 1 < attackTime) {
                time++;
                combo++;

                currentHealth += healPerSecond;
                if (currentHealth > maxHealth) currentHealth = maxHealth;

                if (combo == bandageTime) {
                    currentHealth += bonusHeal;
                    if (currentHealth > maxHealth) currentHealth = maxHealth;
                    combo = 0;
                }
            }

            // 공격 처리
            time = attackTime;
            currentHealth -= attackDamage;
            if (currentHealth <= 0) return -1; // 사망

            combo = 0; // 기술 취소
        }

        return currentHealth;
    }
}
