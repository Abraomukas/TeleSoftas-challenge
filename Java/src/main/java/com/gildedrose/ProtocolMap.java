package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class ProtocolMap {
    private final Map<String, UpdateProtocol> itemProtocols;

    public ProtocolMap() {
        itemProtocols = new HashMap<>();
        itemProtocols.put(AgedBrieProtocol.LABEL, new AgedBrieProtocol());
        itemProtocols.put(BackstageTicketProtocol.LABEL, new BackstageTicketProtocol());
        itemProtocols.put(SulfurasProtocol.LABEL, new SulfurasProtocol());
        itemProtocols.put(ConjuredProtocol.LABEL, new ConjuredProtocol());
    }

    public Map<String, UpdateProtocol> getItemProtocols() {
        return itemProtocols;
    }
}
