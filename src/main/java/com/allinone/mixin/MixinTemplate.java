package com.allinone.mixin;

import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.world.border.WorldBorder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import com.allinone.modules.BorderNoclipModule;

@Mixin(WorldBorder.class)
public abstract class MixinTemplate {
}
