package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		String unitClass = UNITS_PACKAGE_NAME + unitType;

		Class clazz = Class.forName(unitClass);
		Constructor<Unit> declaredConstructor = clazz.getDeclaredConstructor();
		declaredConstructor.setAccessible(true);

		return declaredConstructor.newInstance();
	}
}
