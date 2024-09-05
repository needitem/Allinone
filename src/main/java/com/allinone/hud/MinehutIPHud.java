package com.allinone.hud;

import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.utils.render.color.Color;
import com.allinone.Addon;

import static meteordevelopment.meteorclient.MeteorClient.mc;
import static com.allinone.Addon.MinehutIP;
import static com.allinone.Addon.spoofedIP;

public class MinehutIPHud extends HudElement {
    public static final HudElementInfo<MinehutIPHud> INFO = new HudElementInfo<>(Addon.HUD, "Minehut IP",
            "The IP of the minehut server you're currently playing on", MinehutIPHud::new);

    public MinehutIPHud() {
        super(INFO);
    }

    @Override
    public void render(HudRenderer renderer) {
        String username = mc.getSession().getUsername();
        setSize(renderer.textWidth("Minehut IP: " + MinehutIP, true), renderer.textHeight(true));
        renderer.text("Minehut IP: " + MinehutIP, x, y, Color.WHITE, true);
    }
}
