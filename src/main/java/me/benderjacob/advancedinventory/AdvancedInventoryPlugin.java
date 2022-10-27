package me.benderjacob.advancedinventory;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ColorUtil;

import java.awt.*;

@Slf4j
@PluginDescriptor(
	name = "Advanced Inventory",
		tags = "inventory",
		description = "A collection of advanced utils for the inventory"
)
public class AdvancedInventoryPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private AdvancedInventoryConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Advanced Inventory started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Advanced Inventory stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if(event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
			return;

		client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", ColorUtil.wrapWithColorTag("Inventory Changed", ColorUtil.fromHex("0000cc")), null);
	}

	@Provides
	AdvancedInventoryConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AdvancedInventoryConfig.class);
	}

	private void updateInventoryOverlay(final Item item, final ItemComposition comp)
	{

	}
}
