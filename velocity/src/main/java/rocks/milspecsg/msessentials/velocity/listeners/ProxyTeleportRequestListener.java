/*
 *     MSEssentials - MilSpecSG
 *     Copyright (C) 2020 STG_Allen
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package rocks.milspecsg.msessentials.velocity.listeners;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import net.kyori.text.TextComponent;
import rocks.milspecsg.msessentials.api.plugin.PluginMessages;
import rocks.milspecsg.msessentials.velocity.events.ProxyTeleportRequestEvent;

public class ProxyTeleportRequestListener {

    @Inject
    private PluginMessages<TextComponent> pluginMessages;

    @Subscribe
    public void onTeleportRequest(ProxyTeleportRequestEvent event) {
        event.getTargetPlayer().sendMessage(pluginMessages.getTeleportRequestReceived(event.getSourcePlayer().getUsername()));
        event.getSourcePlayer().sendMessage(pluginMessages.getTeleportRequestSent(event.getTargetPlayer().getUsername()));

        //Fire plugin message events
    }
}
