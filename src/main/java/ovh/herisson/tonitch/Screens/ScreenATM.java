package ovh.herisson.tonitch.Screens;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import ovh.herisson.tonitch.block.Containers.ContainerATM;

@OnlyIn(Dist.CLIENT)
public class ScreenATM extends ContainerScreen<ContainerATM> {
    public ScreenATM(ContainerATM Container, PlayerInventory inv, ITextComponent titleIn) {
        super(Container, inv, titleIn);
    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        super.render(p_render_1_, p_render_2_, p_render_3_);
        this.renderBackground();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.minecraft.getTextureManager().bindTexture(new ResourceLocation("hbm", "textures/gui/container/ATM.png"));
    }
}
