/**
 * This file is part of PacketWrapper.
 * Copyright (C) 2012-2015 Kristian S. Strangeland
 * Copyright (C) 2015 dmulloy2
 *
 * PacketWrapper is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PacketWrapper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with PacketWrapper.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerEntityDestroy extends AbstractPacket {
    public static final PacketType TYPE = PacketType.Play.Server.ENTITY_DESTROY;
    
    public WrapperPlayServerEntityDestroy() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayServerEntityDestroy(PacketContainer packet) {
        super(packet, TYPE);
    }
    
    /**
     * Retrieve Count.
     * <p>
     * Notes: length of following array
     * @return The current Count
     */
    public int getCount() {
        return handle.getIntegerArrays().read(0).length;
    }
    
    /**
     * Retrieve Entity IDs.
     * <p>
     * Notes: the list of entities of destroy
     * @return The current Entity IDs
     */
    public int[] getEntityIDs() {
        return handle.getIntegerArrays().read(0);
    }
    
    /**
     * Set Entity IDs.
     * @param value - new value.
     */
    public void setEntityIds(int[] value) {
        handle.getIntegerArrays().write(0, value);
    }
    
}
