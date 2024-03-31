package magicGame.models.magics;

import magicGame.common.ExceptionMessages;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicImpl implements Magic {

    private String name;
    private int bulletsCount;

    protected MagicImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGIC_NAME);
        }

        this.name = name;
    }

    private void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(INVALID_MAGIC_BULLETS_COUNT);
        }

        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsCount() {
        return bulletsCount;
    }

    @Override
    public int fire() {
        if (this.getClass().getSimpleName().equals("RedMagic")) {
            this.bulletsCount -= 1;
        } else if (this.getClass().getSimpleName().equals("BlackMagic")) {
            this.bulletsCount -= 10;
        }

        return Math.max(this.bulletsCount, 0);
    }
}
