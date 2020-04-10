package com.kh.parkBBakBBak.view.cafe;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class TestFont {

	public static void main(String[] args)

    {

          GraphicsEnvironment ge = null;

          ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

          Font[] fonts = ge.getAllFonts();

         

          for(int i=0; i<fonts.length;i++){

                 System.out.println(fonts[i].getFontName());

          }

    }

}
