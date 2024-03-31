package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician {

    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    protected MagicianImpl(String username, int health, int protection, boolean isAlive, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.isAlive = isAlive;
        this.setMagic(magic);
    }

    private void setUsername(String username) {
        if (null == username || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }

        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }

        this.health = health;
    }

    private void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }

        this.protection = protection;
    }

    private void setMagic(Magic magic) {
        if (null == magic) {
            throw new NullPointerException(INVALID_MAGIC_NAME);
        }

        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void takeDamage(int points) {
        if (this.protection > 0) {
            this.protection -= points;
        } else {
            this.health -= points;
        }

        if (this.health <= 0) {
            isAlive();
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n" +
                "Health: %d%n" +
                "Protection: %d%n" +
                "Magic: %s%n",
                this.getClass().getSimpleName(),
                this.username,
                this.health,
                this.protection,
                this.magic.getName());
    }
}
