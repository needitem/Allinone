/*
 * This file is part of Meteor Satellite Addon (https://github.com/crazycat256/meteor-satellite-addon).
 * Copyright (c) crazycat256.
 */

package com.allinone;

import com.mojang.logging.LogUtils;
import com.allinone.modules.seedmap.*;

import com.allinone.commands.*;
import com.allinone.modules.*;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;

import java.util.ArrayList;

import org.slf4j.Logger;

import com.google.gson.Gson;
import net.minecraft.item.Items;
import com.allinone.hud.*;
import org.slf4j.Logger;
import com.allinone.utils.Regex;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static meteordevelopment.meteorclient.MeteorClient.mc;
import static com.allinone.util.*;

public class Addon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Satellite");
    public static final HudGroup HUD = new HudGroup("Asteroide");
    public static final Gson gson = new Gson();
    public static List<String> banlist = new ArrayList<>();
    public static String spoofedIP = "?";
    public static String MinehutIP = "?";
    public static String trackedPlayer = null;
    public static double[] lastPos = { 0, 0, 0 };
    public static List<String> trolls = new ArrayList<>();
    public static List<String> notInsults = new ArrayList<>();
    public static boolean slotttt = false;

    @Override
    public void onInitialize() {
        LOG.info("Initializing Satellite");

        // Modules
        Modules.get().add(new EventlessFly());
        Modules.get().add(new Phase());
        Modules.get().add(new InfiniteClickTP());
        Modules.get().add(new InfiniteInteract());
        Modules.get().add(new KnockbackTweaks());
        Modules.get().add(new SeedMap());
        Modules.get().add(new AutoFrameDupe());
        Modules.get().add(new SpeedBypass());
        Modules.get().add(new NBTTooltip());
        Modules.get().add(new VecFly());
        Modules.get().add(new AutoFarm());
        Modules.get().add(new AutoReply());
        Modules.get().add(new PaperDupe());
        Modules.get().add(new ServerCrashModule());
        Modules.get().add(new AutoChatGame());
        Modules.get().add(new BanStuffs());
        Modules.get().add(new BetterBungeeSpoofModule());
        Modules.get().add(new BorderNoclipModule());
        Modules.get().add(new WordFilterModule());
        Modules.get().add(new EncryptChatModule());
        Modules.get().add(new Magnet());

        // Require UI TPUtils
        if (UiUtils.uiUtilsClass != null) {
            Modules.get().add(new UiUtils());
        }

        // Commands
        Commands.add(new FrameDrop());
        Commands.add(new TPCamCommand());
        Commands.add(new TPCommand());
        Commands.add(new GetNbtItem());
        // HUD
        addHud(Username.INFO);
        addHud(SpoofedIPHUD.INFO);
        addHud(MinehutIPHud.INFO);
        util.banstuff();

    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "com.allinone";
    }

}
