package ovh.herisson.tonitch.block.Containers.Screens;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import ovh.herisson.tonitch.HBM;
import ovh.herisson.tonitch.Money.MoneyProvider;
import ovh.herisson.tonitch.block.Containers.ContainerATM;

@OnlyIn(Dist.CLIENT)
public class ScreenATM extends ContainerScreen<ContainerATM> {
    private float PlayerMoney;

    public ScreenATM(ContainerATM Container, PlayerInventory inv, ITextComponent titleIn) {
        super(Container, inv, titleIn);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float)(this.ySize - 96 + 2), 4210752);
        this.playerInventory.player.getCapability(MoneyProvider.money).ifPresent(h -> {
            this.font.drawString(String.valueOf(h.getMoney()), (59-this.font.getStringWidth(String.valueOf(h.getMoney())))/2+58  ,20,0xffffff);
        });
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.minecraft.getTextureManager().bindTexture(new ResourceLocation(HBM.MODID, "textures/gui/container/atm.png"));
        int relX = (this.width - this.xSize) /2;
        int relY = (this.height - this.ySize) /2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
    }
}
