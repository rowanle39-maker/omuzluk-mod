package com.omuzluk.client.render;

import com.omuzluk.OmuzlukMod;
import com.omuzluk.capability.IOmuzlukData;
import com.omuzluk.event.CapabilityAttachHandler;
import com.omuzluk.item.EnumOmuzlukMaterial;
import com.omuzluk.item.ItemOmuzluk;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * Sadece kozmetik: oyuncunun sag/sol omzunda kucuk bir "omuzluk" kutucugu render eder.
 * Renk, esyanin materyaline gore degisir. Zirh degeri / oyun mekanigi etkisi yoktur.
 */
public class LayerOmuzluk implements LayerRenderer<EntityPlayer> {

    private final RenderPlayer renderPlayer;
    private final ModelRenderer box;

    public LayerOmuzluk(RenderPlayer renderPlayer) {
        this.renderPlayer = renderPlayer;
        this.box = new ModelRenderer(64, 32);
        this.box.setTextureOffset(0, 0);
        this.box.addBox(-2.5F, -1.5F, -2.5F, 5, 3, 5, 0.15F);
    }

    @Override
    public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks,
                               float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        IOmuzlukData data = CapabilityAttachHandler.get(player);
        if (data == null) return;

        renderSide(player, data.getLeft(), true, scale);
        renderSide(player, data.getRight(), false, scale);
    }

    private void renderSide(EntityPlayer player, ItemStack stack, boolean left, float scale) {
        if (stack.isEmpty() || !(stack.getItem() instanceof ItemOmuzluk)) return;

        EnumOmuzlukMaterial material = ((ItemOmuzluk) stack.getItem()).getMaterial();
        ResourceLocation texture = new ResourceLocation(OmuzlukMod.MODID,
                "textures/models/omuzluk_" + material.getName() + "_render.png");

        GlStateManager.pushMatrix();
        renderPlayer.bindTexture(texture);

        // Modelin govde/kol kismina gore omuz pozisyonuna tasi.
        renderPlayer.getMainModel().bipedBody.postRender(scale);
        GlStateManager.translate(left ? 0.31F : -0.31F, 0.10F, 0F);

        box.render(scale);

        GlStateManager.popMatrix();
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
