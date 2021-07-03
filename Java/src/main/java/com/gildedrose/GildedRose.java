package com.gildedrose;

import java.util.Map;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateProtocol protocol = createProtocolFor(item);
            protocol.update(item);
        }
    }

    private UpdateProtocol createProtocolFor(Item item) {
        Map<String, UpdateProtocol> protocolMap = new ProtocolMap().getItemProtocols();
        UpdateProtocol protocol = protocolMap.get(item.name);
        if (protocol != null) {
            return protocol;
        }
        return new UpdateProtocol();
    }
}
