package com.exilegl.box.text;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class Text
{
  static Font FONT_BOLD;
  public static UnicodeFont FONT_BOLDU_GRAY;
  static UnicodeFont FONT_BOLDU_WHITE;
  static UnicodeFont FONT_BOLDU_GRAY_LARGE;
  static UnicodeFont FONT_BOLDU_WHITE_LARGE;
  
  public static void loadFonts()
    throws SlickException
  {
    FONT_BOLD = new Font("Serif", 1, 24);
    FONT_BOLDU_GRAY = new UnicodeFont(FONT_BOLD, FONT_BOLD.getSize(), FONT_BOLD.isBold(), FONT_BOLD.isItalic());
    FONT_BOLDU_GRAY.addAsciiGlyphs();
    FONT_BOLDU_GRAY.addGlyphs(400, 600);
    FONT_BOLDU_GRAY.addGlyphs("���������������������");
    FONT_BOLDU_GRAY.getEffects().add(new ColorEffect(Color.GREEN.darker()));
    FONT_BOLDU_GRAY.loadGlyphs();
    
    FONT_BOLDU_WHITE = new UnicodeFont(FONT_BOLD, FONT_BOLD.getSize(), FONT_BOLD.isBold(), FONT_BOLD.isItalic());
    FONT_BOLDU_WHITE.addAsciiGlyphs();
    FONT_BOLDU_WHITE.addGlyphs(400, 600);
    FONT_BOLDU_WHITE.getEffects().add(new ColorEffect(Color.GREEN));
    FONT_BOLDU_WHITE.loadGlyphs();
    
    FONT_BOLDU_GRAY_LARGE = new UnicodeFont(FONT_BOLD, 48, FONT_BOLD.isBold(), FONT_BOLD.isItalic());
    FONT_BOLDU_GRAY_LARGE.addAsciiGlyphs();
    FONT_BOLDU_GRAY_LARGE.addGlyphs(400, 600);
    FONT_BOLDU_GRAY_LARGE.getEffects().add(new ColorEffect(Color.GREEN.darker()));
    FONT_BOLDU_GRAY_LARGE.loadGlyphs();
    
    FONT_BOLDU_WHITE_LARGE = new UnicodeFont(FONT_BOLD, 48, FONT_BOLD.isBold(), FONT_BOLD.isItalic());
    FONT_BOLDU_WHITE_LARGE.addAsciiGlyphs();
    FONT_BOLDU_WHITE_LARGE.addGlyphs(400, 600);
    FONT_BOLDU_WHITE_LARGE.getEffects().add(new ColorEffect(Color.GREEN));
    FONT_BOLDU_WHITE_LARGE.loadGlyphs();
  }
  
  public static void drawBold(Graphics g, String text, float x, float y)
  {
    FONT_BOLDU_GRAY.drawString(x - 2, y - 2, text);
    FONT_BOLDU_WHITE.drawString(x, y, text);
  }
  
  public static void drawLarge(Graphics g, String text, float x, float y)
  {
    FONT_BOLDU_GRAY_LARGE.drawString(x - 2, y - 2, text);
    FONT_BOLDU_WHITE_LARGE.drawString(x, y, text);
  }
}