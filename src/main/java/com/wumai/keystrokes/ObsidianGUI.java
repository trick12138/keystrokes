package com.wumai.keystrokes;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;

public class ObsidianGUI extends AbstractGui {
    private final int x = 32;
    private final int y = 32;
    private final int inter = 0;
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation(Utils.MOD_ID, "textures/gui/hud.png");
    private final ResourceLocation HUD2 = new ResourceLocation(Utils.MOD_ID, "textures/gui/hud2.png");
    private final ResourceLocation RGBBackGround = new ResourceLocation(Utils.MOD_ID, "textures/gui/rgb.png");
    private MatrixStack matrixStack;
    private int size = 1;
    private float zoom = 0.4f;

    private String getFloatValue(Float value) {
        String stemp;
        int temp = Math.round((value - value.intValue()) * 100);
        if (temp % 100 == 0)
            stemp = String.format("%.0f",value);
        else if (temp % 10 == 0)
            stemp = String.format("%.1f",value);
        else
            stemp = String.format("%.2f",value);
        return stemp;
    }

    public ObsidianGUI(MatrixStack matrixStack) {
        this.minecraft = Minecraft.getInstance();
        this.matrixStack = matrixStack;
    }

    public void setMatrixStack(MatrixStack stack) {
        this.matrixStack = stack;
    }

    public void render_W_On() {
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD);
        blit(matrixStack, x, y, 64, 0, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_A_On() {
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD);
        blit(matrixStack, x - (int)(16 * size) + inter, y + (int)(16 * size) + inter, 0, 64, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_S_On() {
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD);
        blit(matrixStack, x, y + (int)(16 * size) + inter, 64, 64, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_D_On() {
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD);
        blit(matrixStack, x + (int)(16 * size) + inter, y + (int)(16 * size) + inter, 128, 64, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_Left_On(){
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD);
        blit(matrixStack, x - (int)(16 * size) - inter, y, 0, 0, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_Right_On(){
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD);
        blit(matrixStack, x + (int)(16 * size) + inter, y, 128, 0, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_Shift_On(){
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD);
        blit(matrixStack, x - (int)(16 * size) - inter, y + (int)(16 * size) + inter + (int)(16 * size) + inter, 0, 128 + 8, (int)(48 * size), (int)(8 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_Ctrl_On(){
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD);
        blit(matrixStack, x - (int)(16 * size) - inter, y + (int)(16 * size) + inter + (int)(16 * size) + inter + (int)(8 * size) + inter, 0, 128, (int)(16 * size), (int)(8 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_Space_On(){
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD);
        blit(matrixStack, x, y + (int)(16 * size) + inter + (int)(16 * size) + inter + (int)(8 * size) + inter, 64, 128, (int)(32 * size), (int)(8 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_W_Down() {
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD2);
        blit(matrixStack, x, y, 64, 0, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_A_Down() {
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD2);
        blit(matrixStack, x - (int)(16 * size) - inter, y + (int)(16 * size) + inter, 0, 64, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_S_Down() {
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD2);
        blit(matrixStack, x, y + (int)(16 * size) + inter, 64, 64, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_D_Down() {
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD2);
        blit(matrixStack, x + (int)(16 * size) + inter, y + (int)(16 * size) + inter, 128, 64, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_Left_Down(){
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD2);
        blit(matrixStack, x - (int)(16 * size) - inter, y, 0, 0, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_Right_Down(){
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD2);
        blit(matrixStack, x + (int)(16 * size) + inter, y, 128, 0, (int)(16 * size), (int)(16 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }
    public void render_Shift_Down(){
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD2);
        blit(matrixStack, x - (int)(16 * size) - inter, y + (int)(16 * size) + inter + (int)(16 * size) + inter, 0, 128 + 8, (int)(48 * size), (int)(8 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }
    public void render_Ctrl_Down(){
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD2);
        blit(matrixStack, x - (int)(16 * size) - inter, y + (int)(16 * size) + inter + (int)(16 * size) + inter + (int)(8 * size) + inter, 0, 128, (int)(16 * size), (int)(8 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_Space_Down(){
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(HUD2);
        blit(matrixStack, x, y + (int)(16 * size) + inter + (int)(16 * size) + inter + (int)(8 * size) + inter, 64, 128, (int)(32 * size), (int)(8 * size), (int)(48 * size), (int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_RGBBackGround(int rgbx, int rgby){
        GlStateManager._enableBlend();
        this.minecraft.getTextureManager().bind(RGBBackGround);
        //上边
        blit(matrixStack,x - (int)(16 * size) - inter - 1,y - 1,rgbx,rgby,(int)(48 * size) + 2 * inter + 2,1,(int)(48 * size),(int)(48 * size));
        //左边
        blit(matrixStack, x - (int)(16 * size) - inter - 1, y,rgbx,rgby,1,(int)(48 * size) + 2 * inter + 1,(int)(48 * size),(int)(48 * size));
        //下边
        blit(matrixStack,x - (int)(16 * size) - inter - 1,y + (int)(16 * size * 3),rgbx,rgby,(int)(48 * size) + 2 * inter + 2,1,(int)(48 * size),(int)(48 * size));
        //右边
        blit(matrixStack, x + (int)(16 * size * 2) + inter, y,rgbx,rgby,1,(int)(48 * size) + 2 * inter + 1,(int)(48 * size),(int)(48 * size));
        GlStateManager._disableBlend();
    }

    public void render_CPS_L(float CPS){
        GlStateManager._enableBlend();
        GlStateManager._pushMatrix();
        GlStateManager._scaled(zoom,zoom,1.0f);
        drawString(matrixStack,this.minecraft.font, "LCPS: " + getFloatValue(CPS),(int)((x - (int)(16 * size)) * (1 / zoom)), (int)((y + (int)(16 * size * 3) + 2) * (1 / zoom)),0x00ffffff);
        GlStateManager._popMatrix();
        GlStateManager._disableBlend();
    }

    public void render_CPS_R(float CPS){
        FontRenderer fontRenderer = Minecraft.getInstance().font;
        GlStateManager._enableBlend();
        GlStateManager._pushMatrix();
        GlStateManager._scaled(zoom,zoom,1.0f);
        drawString(matrixStack,this.minecraft.font, "RCPS: " + getFloatValue(CPS), (int) ((x + (int)(16 * size)) * (1 / zoom)), (int)((y + (int)(16 * size * 3) + 2) * (1 / zoom)),0x00ffffff);
        GlStateManager._popMatrix();
        GlStateManager._disableBlend();
    }
}
