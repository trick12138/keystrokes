package com.wumai.keystrokes;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Mod.EventBusSubscriber()
public class draw {
    static Boolean W = false;
    static Boolean A = false;
    static Boolean S = false;
    static Boolean D = false;
    static Boolean L = false;
    static Boolean R = false;
    static Boolean Shift = false;
    static Boolean Ctrl = false;
    static Boolean Space = false;
    static int time = 0;
    static int clicksL = 0;
    static long lastClickL = 0;
    static long currentClickL = 0;
    static long firstClickL = 0;
    static float CPSL = 0;
    static int clicksR = 0;
    static long lastClickR = 0;
    static long currentClickR = 0;
    static long firstClickR = 0;
    static float CPSR = 0;

    @SubscribeEvent
    public static void onOverlayRender(RenderGameOverlayEvent event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        if (Minecraft.getInstance().player == null) {
            return;
        }
        ObsidianGUI obsidianGUI;
        obsidianGUI = new ObsidianGUI(event.getMatrixStack());
        obsidianGUI.render_RGBBackGround(time,0);
        obsidianGUI.render_CPS_L(CPSL);
        obsidianGUI.render_CPS_R(CPSR);
        if (W == true)
            obsidianGUI.render_W_Down();
        else
            obsidianGUI.render_W_On();
        if (A == true)
            obsidianGUI.render_A_Down();
        else
            obsidianGUI.render_A_On();
        if (S == true)
            obsidianGUI.render_S_Down();
        else
            obsidianGUI.render_S_On();
        if (D == true)
            obsidianGUI.render_D_Down();
        else
            obsidianGUI.render_D_On();
        if (L == true)
            obsidianGUI.render_Left_Down();
        else
            obsidianGUI.render_Left_On();
        if (R == true)
            obsidianGUI.render_Right_Down();
        else
            obsidianGUI.render_Right_On();
        if (Shift == true)
            obsidianGUI.render_Shift_Down();
        else
            obsidianGUI.render_Shift_On();
        if (Ctrl == true)
            obsidianGUI.render_Ctrl_Down();
        else
            obsidianGUI.render_Ctrl_On();
        if (Space == true)
            obsidianGUI.render_Space_Down();
        else
            obsidianGUI.render_Space_On();
    }

    @SubscribeEvent
    public static void onKeyInputEvent(InputEvent.KeyInputEvent keyEvent){
        if (keyEvent.getKey() == GLFW.GLFW_KEY_W && keyEvent.getAction() == GLFW.GLFW_PRESS) {
            W = true;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_A && keyEvent.getAction() == GLFW.GLFW_PRESS) {
            A = true;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_S && keyEvent.getAction() == GLFW.GLFW_PRESS) {
            S = true;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_D && keyEvent.getAction() == GLFW.GLFW_PRESS) {
            D = true;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_LEFT_SHIFT && keyEvent.getAction() == GLFW.GLFW_PRESS){
            Shift = true;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_LEFT_CONTROL && keyEvent.getAction() == GLFW.GLFW_PRESS){
            Ctrl = true;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_SPACE && keyEvent.getAction() == GLFW.GLFW_PRESS){
            Space = true;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_W && keyEvent.getAction() == GLFW.GLFW_RELEASE) {
            W = false;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_A && keyEvent.getAction() == GLFW.GLFW_RELEASE) {
            A = false;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_S && keyEvent.getAction() == GLFW.GLFW_RELEASE) {
            S = false;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_D && keyEvent.getAction() == GLFW.GLFW_RELEASE) {
            D = false;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_LEFT_SHIFT && keyEvent.getAction() == GLFW.GLFW_RELEASE){
            Shift = false;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_LEFT_CONTROL && keyEvent.getAction() == GLFW.GLFW_RELEASE){
            Ctrl = false;
        }
        if (keyEvent.getKey() == GLFW.GLFW_KEY_SPACE && keyEvent.getAction() == GLFW.GLFW_RELEASE){
            Space = false;
        }
        ++time;
    }

    @SubscribeEvent
    public static void onMouseInputEvent(InputEvent.MouseInputEvent mouseEvent){
        if (mouseEvent.getButton() == GLFW.GLFW_MOUSE_BUTTON_LEFT && mouseEvent.getAction() == GLFW.GLFW_PRESS) {
            L = true;
        }
        if (mouseEvent.getButton() == GLFW.GLFW_MOUSE_BUTTON_RIGHT && mouseEvent.getAction() == GLFW.GLFW_PRESS) {
            R = true;
        }
        if (mouseEvent.getButton() == GLFW.GLFW_MOUSE_BUTTON_LEFT && mouseEvent.getAction() == GLFW.GLFW_RELEASE) {
            L = false;
            if (currentClickL - lastClickL > 3000 && lastClickL != 0) {
                currentClickL = 0;
                lastClickL = 0;
                clicksL = 0;
                firstClickL = 0;
                return;
            }
            else {
                if (firstClickL == 0)
                    firstClickL = Calendar.getInstance().getTimeInMillis();
                lastClickL = currentClickL;
                currentClickL = Calendar.getInstance().getTimeInMillis();
                ++clicksL;
            }

        }
        if (mouseEvent.getButton() == GLFW.GLFW_MOUSE_BUTTON_RIGHT && mouseEvent.getAction() == GLFW.GLFW_RELEASE) {
            R = false;
            if (currentClickR - lastClickR > 3000 && lastClickR != 0) {
                currentClickR = 0;
                lastClickR = 0;
                clicksR = 0;
                firstClickR = 0;
                return;
            }
            else {
                if (firstClickR == 0)
                    firstClickR = Calendar.getInstance().getTimeInMillis();
                lastClickR = currentClickR;
                currentClickR = Calendar.getInstance().getTimeInMillis();
                ++clicksR;
            }
        }
        ++time;
    }

    @SubscribeEvent
    public static void on(TickEvent tickEvent){
        if (currentClickL != lastClickL)
            CPSL = ((float) clicksL * 1000 / (float)(currentClickL - firstClickL));
        if (currentClickR != lastClickR)
            CPSR = ((float) clicksR * 1000 / (float)(currentClickR - firstClickR));
    }
}