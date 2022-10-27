package me.benderjacob.advancedinventory;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("AdvancedInventory")
public interface AdvancedInventoryConfig extends Config
{
	@ConfigItem(
		keyName = "TestOption",
		name = "A test option",
		description = "The message to show to the user when they login"
	)
	default String greeting()
	{
		return "Hello";
	}
}
