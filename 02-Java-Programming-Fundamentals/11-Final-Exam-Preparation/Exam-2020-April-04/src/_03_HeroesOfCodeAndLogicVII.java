import java.util.*;

public class _03_HeroesOfCodeAndLogicVII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroes = new LinkedHashMap<>();

        int maxHP = 100;
        int maxMP = 200;

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String heroName = input[0];
            int hp = Integer.parseInt(input[1]);
            int mp = Integer.parseInt(input[2]);

            if (!heroes.containsKey(heroName)) {
                heroes.put(heroName, new ArrayList<>());
            }

            heroes.get(heroName).add(hp);
            heroes.get(heroName).add(mp);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] tokens = command.split("\\s+\\-\\s+");
            String operation = tokens[0];

            if (operation.equals("CastSpell")) {
               castSpell(tokens, heroes);
            } else if (operation.equals("TakeDamage")) {
                takeDamage(tokens, heroes);
            } else if (operation.equals("Recharge")) {
                recharge(tokens, heroes, maxMP);
            } else if (operation.equals("Heal")) {
                heal(tokens, heroes, maxHP);
            }

            command = scanner.nextLine();
        }

        print(heroes);
    }

    public static void castSpell(String[] tokens, Map<String, List<Integer>> heroes) {

        String heroName = tokens[1];
        int neededMP = Integer.parseInt(tokens[2]);
        String spellName = tokens[3];

        if (heroes.get(heroName).get(1) >= neededMP) {
            heroes.get(heroName).set(1, heroes.get(heroName).get(1) - neededMP);
            System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                    heroName,
                    spellName,
                    heroes.get(heroName).get(1));
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
        }
    }

    public static void takeDamage(String[] tokens, Map<String, List<Integer>> heroes) {

        String heroName = tokens[1];
        int damage = Integer.parseInt(tokens[2]);
        String attacker = tokens[3];

        if (heroes.get(heroName).get(0) - damage > 0) {
            heroes.get(heroName).set(0, heroes.get(heroName).get(0) - damage);
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                    heroName,
                    damage,
                    attacker,
                    heroes.get(heroName).get(0));
        } else {
            heroes.remove(heroName);
            System.out.printf("%s has been killed by %s!%n", heroName, attacker);
        }
    }

    public static void recharge(String[] tokens, Map<String, List<Integer>> heroes, int maxMP) {

        String heroName = tokens[1];
        int amountMP = Integer.parseInt(tokens[2]);

        if (heroes.get(heroName).get(1) + amountMP <= maxMP) {
            heroes.get(heroName).set(1, heroes.get(heroName).get(1) + amountMP);
            System.out.printf("%s recharged for %d MP!%n", heroName, amountMP);
        } else {
            int difference = maxMP - heroes.get(heroName).get(1);
            heroes.get(heroName).set(1, maxMP);
            System.out.printf("%s recharged for %d MP!%n", heroName, difference);
        }
    }

    public static void heal(String[] tokens, Map<String, List<Integer>> heroes, int maxHP) {

        String heroName = tokens[1];
        int amountHP = Integer.parseInt(tokens[2]);

        if (heroes.get(heroName).get(0) + amountHP <= maxHP) {
            heroes.get(heroName).set(0, heroes.get(heroName).get(0) + amountHP);
            System.out.printf("%s healed for %d HP!%n", heroName, amountHP);
        } else {
            int difference = maxHP - heroes.get(heroName).get(0);
            heroes.get(heroName).set(0, maxHP);
            System.out.printf("%s healed for %d HP!%n", heroName, difference);
        }
    }

    public static void print(Map<String, List<Integer>> heroes) {

        for (Map.Entry<String, List<Integer>> entry: heroes.entrySet()) {
            System.out.printf("%s%n  HP: %d%n  MP: %d%n",
                    entry.getKey(),
                    entry.getValue().get(0),
                    entry.getValue().get(1));
        }
    }
}
