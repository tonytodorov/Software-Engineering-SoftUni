package magicGame.models.magicians;

import magicGame.models.magics.Magic;

public class Wizard extends MagicianImpl {

    public Wizard(String username, int health, int protection, boolean isAlive, Magic magic) {
        super(username, health, protection, isAlive, magic);
    }
}
