package barracksWars.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Runnable {
	void run() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
