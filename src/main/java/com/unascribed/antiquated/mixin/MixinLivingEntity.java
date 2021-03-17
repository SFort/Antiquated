package com.unascribed.antiquated.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.unascribed.antiquated.Antiquated;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {

	@Inject(at=@At("HEAD"), method="setSprinting(Z)V", cancellable=true)
	public void setSprinting(boolean sprinting, CallbackInfo ci) {
		if (Antiquated.isInCursedAntiqueBiome((Entity)(Object)this) && sprinting) {
			ci.cancel();
		}
	}
	
}
