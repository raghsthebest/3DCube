import javax.swing.*;

import java.awt.*;

public class TDTPP extends JPanel{

	int l;
	
	double[][] p;
	
	int count=0;
	
	int shift=0;
	
	double turn=(Math.PI)/4/23;;
	int angle;
	
	public TDTPP(){
		init();
	} 
	
	public TDTPP(int l){
		this.l = l;
		init();
	}
	
	public void init(){
		p = new double[3][15000];
		
		/*for(int i=-l/4;i<l/4;i++){
			for(int k=0;k<2;k++){
				if(i==-l/4||i==(l/4-1)){
					for(int j=-l/4;j<l/4;j++){
						if(j==-l/4||j==(l/4-1)){
							for(int m=-l/4;m<l/4;m++){
								p[0][count] = i;
								p[1][count] = j;
								p[2][count] = m;
								count++;
							}
						}else{
							p[0][count] = i;
							p[1][count] = j;
							p[2][count] = k*l/2-l/4;
							count++;
						}
					}
				}else{
					for(int j=0;j<2;j++){
						p[0][count] = i;
						p[1][count] = j*l/2 - l/4;
						p[2][count] = k*l/2-l/4;
						count++;
					}
				}
			}
		}*/
		
		addRect(l/2, l/2, l/2, -l/4, -l/4, -l/4);
		//addRect(l/2, l/2, l/2, l/2, -l/4, 2*l);
		/*check(count);
		addRect(l/8, l/4, 8, -l/16, -l/4, l/4-8);
		check(count);
		addRect(l/16, l/16, 8, -l/8-l/32, l/8-l/32, l/4-8);
		addRect(l/16, l/16, 8, l/8-l/32, l/8-l/32, l/4-8);
		check(count);
		
		
		for(int i=0;i<l/4;i++){
			for(int j=0;j<2;j++){
				for(int k=0;k<2;k++){
					p[0][count] = k*l/2 - l/4 + ((k*-2)+1)*i;
					p[1][count] = i + l/4;
					p[2][count] = j*l/2-l/4;
					count++;
				}
			}
		}
		for(int i=1;i<l/2;i++){
			p[0][count] = 0;
			p[1][count] = l/2;
			p[2][count] = l/4-i;
			count++;
		}
		*/
		//check(count);
		
		repaint();
		
	}
	
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, l, l);
		
		int[] pintx = ConvertToPoints(p[0]);
		int[] pinty = ConvertToPoints(p[1]);
		
		//System.out.println("3D Test..loeolssloejasl;jfliej");
		
		g.setColor(Color.LIGHT_GRAY);
		
		//g.drawLine(0,300,600,300);
		//g.drawLine(300,0,300,600);
		//g.drawRect(20, 20, 560, 560);
		
		Font f = new Font("Calibri", 0, 11);
		g.setFont(f);;
		g.drawString("Press the Up and Down arrow keys to rotate around the x-axis", 5, 15);
		g.drawString("Press the Left and Right arrow keys to rotate around the y-axis", 5, 25);
		g.drawString("Hold Shift while pressing the Left and Right arrow keys to rotate around the z-axis", 5, 35);
		
		g.drawString("Raghav Kansal", 525,595);
		
		g.setColor(Color.black);
		

		
		for(int i=0;i<p[0].length;i++){
			/*double rgb1 = Math.abs(p[2][i]-l/4);
			int rgb2 = (int) ((rgb1/(l/2))*64);
			Color c = new Color(rgb2+64, rgb2+64, rgb2+64);*/
			
			double rgb1 = l/2 - p[2][i];
			int rgb2 = (int) ((rgb1/(l/2))*96);
			if(rgb2<0) rgb2=0;
			if(rgb2>255) rgb2=255;
			Color c = new Color(rgb2, rgb2, rgb2);
			
			
			g.setColor(c);
			
			g.fillRect(pintx[i], pinty[i], 1, 1);
			
			
			//g.fillRect((int) p[0][i]+300, (int) p[1][i]+300, 1, 1);
			//g.fillRect((int) pintx[i], (int) pinty[i], 1, 1);
			
			if(i==l){
	 			//g.setColor(Color.black);
			}
		}
		
		
	}
	
	public void addRect(int rw, int rh, int rl, int rx, int ry, int rz){		
		for(int i=rx;i<rx+rw;i++){
			for(int k=0;k<2;k++){
				if(i==rx||i==(rx+rw-1)){
					for(int j=ry;j<ry+rh;j++){
						if(j==ry||j==(ry+rh-1)){
							for(int m=rz;m<rz+rl;m++){
								p[0][count] = i;
								p[1][count] = j;
								p[2][count] = m;
								count++;
							}
						}else{
							p[0][count] = i;
							p[1][count] = j;
							p[2][count] = k*rl+rz;
							count++;
						}
					}
				}else{
					for(int j=0;j<2;j++){
						p[0][count] = i;
						p[1][count] = j*rh + ry;
						p[2][count] = k*rl + rz;
						count++;
					}
				}
			}
		}
	}
	
	
	public int[] ConvertToPoints(double[] ds)
	{
		int[] is = new int[ds.length];
	    for(int i=0;i<ds.length;i++){
	    	//is[i] = (int) (ds[i]*(((p[2][i]+l/4)/4+3*(l/2)/4)/(l/2)));
	    	//is[i]+=l/2;
	    	double depth = (p[2][i]+l/4)/4 + 3*(l/2)/4;
	    	depth/=l/2;
	    	
	    	double d =(int) (ds[i]*depth);
	    	//d/=300;
	    	d+=300;
	    	is[i]=(int) d;
	    	if(i==1){
	    		//check(is[i]);
	    	}
	    	//is[i] = (int) (ds[i]/(p[2][i]/512))+l/2;
	    }
	    return is;
	}
	
	public int[] ConvertToPointsY(double[] ds)
	{
		int[] is = new int[ds.length];
		
	    for(int i=0;i<ds.length;i++){
	    	//is[i] = (int) (ds[i]*(((p[2][i]+l/4)/4+3*(l/2)/4)/(l/2))+l/2);
	    	double depth = p[2][i]+150;
	    	double d =(int) (ds[i]*depth);
	    	d/=300;
	    	d+=300;
	    	is[i]=(int) d;
	    	if(i==1){
	    		//check(is[i]);
	    	}
	    	//is[i] = (int) (ds[i]/(p[2][i]/512))+l/2;
	    }
	    
	    /*for(int i=0;i<ds.length;i++){
	    	is[i] = (int) (0.625*l - ds[i]*(((p[2][i]+l/4)/4+3*(l/2)/4)/(l/2)));
	    	//is[i] = (int) (l/2 - ds[i]/(p[2][i]/512));
	    }*/
	    return is;
	}
	
	public void forever(){
		
	}
	
	public void check(int t){
		System.out.println(t);
	}
	
	public void check(String s){
		System.out.println(s);
	}
	
	public void keyDown(int k){
		if(k==37){	//left arrow key
			if(shift==1){	//Rz
				for(int i=0;i<p[0].length;i++){
					double temp = p[0][i];
					p[0][i] = p[0][i]*Math.cos(-turn) - p[1][i]*Math.sin(-turn);
					p[1][i] = temp*Math.sin(-turn) + p[1][i]*Math.cos(-turn);
				}
				repaint();
			}else{			//Ry
				for(int i=0;i<p[0].length;i++){
					double temp = p[0][i];
					p[0][i] = p[0][i]*Math.cos(-turn) + p[2][i]*Math.sin(-turn);
					p[2][i] = -temp*Math.sin(-turn) + p[2][i]*Math.cos(-turn);
				}
				repaint();
			}
		}
		if(k==39){	//right arrow key
			if(shift==1){	//Rz
				for(int i=0;i<p[0].length;i++){
					double temp = p[0][i];
					p[0][i] = p[0][i]*Math.cos(turn) - p[1][i]*Math.sin(turn);
					p[1][i] = temp*Math.sin(turn) + p[1][i]*Math.cos(turn);
				}
				
				repaint();
			}else{			//Ry
				for(int i=0;i<p[0].length;i++){
					double temp = p[0][i];
					p[0][i] = p[0][i]*Math.cos(turn) + p[2][i]*Math.sin(turn);
					p[2][i] = -temp*Math.sin(turn) + p[2][i]*Math.cos(turn);
				}
				repaint();
			}
		}
		
		if(k==38){	//up arrow key		Rx
			for(int i=0;i<p[0].length;i++){
				double temp = p[1][i];
				p[1][i] = p[1][i]*Math.cos(turn) - p[2][i]*Math.sin(turn);
				p[2][i] = temp*Math.sin(turn) + p[2][i]*Math.cos(turn);
			}			
			repaint();
		}
		if(k==40){	//down arrow key	Rx
			for(int i=0;i<p[0].length;i++){
				double temp = p[1][i];
				p[1][i] = p[1][i]*Math.cos(-turn) - p[2][i]*Math.sin(-turn);
				p[2][i] = temp*Math.sin(-turn) + p[2][i]*Math.cos(-turn);
			}
			repaint();
		}
		
		if(k==65){
			for(int i=0;i<p[0].length;i++){
				p[0][i]-=3;
			}
			repaint();
		}
		if(k==68){
			for(int i=0;i<p[0].length;i++){
				p[0][i]+=3;
			}
			repaint();
		}
		if(k==87){
			for(int i=0;i<p[0].length;i++){
				p[1][i]-=3;
			}
			repaint();
		}
		if(k==83){
			for(int i=0;i<p[0].length;i++){
				p[1][i]+=3;
			}
			repaint();
		}
		if(k==81){
			for(int i=0;i<p[0].length;i++){
				p[2][i]-=3;
			}
			repaint();
		}
		if(k==69){
			for(int i=0;i<p[0].length;i++){
				p[2][i]+=3;
			}
			repaint();
		}
		
		if(k==16){
			shift=1;
		}
		
		
		
		//check(k);
	}
	
	public void keyUp(int k){
		if(k==16){
			shift=0;
		}
	}
	
}
