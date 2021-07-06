/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Scanner;
/*     */ 
/*     */ class Taxi extends Car {
/*     */   Fare fare;
/*     */   
/* 171 */   double x = 0.0D;
/*     */   
/* 172 */   double y = 0.0D;
/*     */   
/* 173 */   int price = 430;
/*     */   
/* 174 */   int price2 = 0;
/*     */   
/* 175 */   int addprice = 150;
/*     */   
/*     */   BigDecimal bd;
/*     */   
/*     */   BigDecimal bc;
/*     */   
/*     */   BigDecimal ba;
/*     */   
/*     */   BigDecimal be;
/*     */   
/*     */   BigDecimal bf;
/*     */   
/*     */   BigDecimal bh;
/*     */   
/* 182 */   double sum2 = 0.0D;
/*     */   
/*     */   double abb;
/*     */   
/*     */   public Taxi() {
/* 187 */     System.out.println("タクシーに乗りました。");
/* 188 */     System.out.println("出庫します。");
/* 189 */     System.out.println("車の名前:" + this.name);
/* 190 */     System.out.println("燃費:" + this.fuelEfficiency + "[km/L]");
/* 191 */     System.out.println("タンク容量:" + this.fuelTank + "[L]");
/* 192 */     System.out.println("残燃料:" + this.gas + "[L]");
/* 193 */     System.out.println("");
/*     */   }
/*     */   
/*     */   public void getFare() {
/* 197 */     System.out.println("");
/* 198 */     System.out.println("初乗り料金は " + this.price + "円です。");
/* 199 */     System.out.println("加算料金は " + this.addprice + "円です。");
/*     */   }
/*     */   
/*     */   public void getX(double paramDouble) {
/* 203 */     this.x = paramDouble;
/*     */   }
/*     */   
/*     */   public void getY(double paramDouble) {
/* 207 */     this.y = paramDouble;
/*     */   }
/*     */   
/*     */   public void movefarePrice(double paramDouble) {
/* 211 */     this.bf = new BigDecimal(paramDouble);
/* 212 */     this.bf = this.bf.setScale(1, RoundingMode.HALF_UP);
/* 213 */     this.price = (int)(this.price + this.addprice * paramDouble * this.fuelEfficiency);
/* 214 */     this.price2 = this.price;
/* 215 */     this.price2 /= 10;
/* 216 */     this.abb = Math.round(this.price2);
/* 217 */     this.price2 *= 10;
/*     */   }
/*     */   
/*     */   public void getfarePrice() {
/* 221 */     System.out.println("");
/* 222 */     System.out.println("現在の料金は " + this.price2 + "円です。");
/*     */   }
/*     */   
/*     */   public void payfarePrice() {
/*     */     while (true) {
/* 228 */       System.out.println("");
/* 229 */       System.out.print("支払金額を入力してください。 ￥=");
/* 230 */       Scanner scanner = new Scanner(System.in);
/* 231 */       int i = scanner.nextInt();
/* 233 */       if (i >= this.price2) {
/* 234 */         int j = i - this.price2;
/* 235 */         System.out.println("");
/* 236 */         System.out.println("おつりは" + j + "円です。");
/* 237 */         System.out.println("料金は0円です。");
/* 238 */         this.price = 430;
/*     */         break;
/*     */       } 
/* 241 */       if (i < this.price2) {
/* 242 */         int j = this.price2 - i;
/* 243 */         System.out.println("");
/* 244 */         System.out.println("金額が" + j + "円不足しています。");
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void getfuel(double paramDouble) {
/* 251 */     this.gas += paramDouble;
/* 252 */     this.ba = new BigDecimal(this.gas);
/* 253 */     this.ba = this.ba.setScale(1, RoundingMode.HALF_UP);
/* 254 */     System.out.println("");
/* 255 */     System.out.print("車に" + paramDouble + "のガソリンを追加しました");
/* 256 */     System.out.println("残りガソリン量は" + this.ba + "[L]です。");
/*     */   }
/*     */   
/*     */   public void move(double paramDouble1, double paramDouble2) {
/* 260 */     double d = Math.sqrt((paramDouble1 - this.x) * (paramDouble1 - this.x) + (paramDouble2 - this.y) * (paramDouble2 - this.y));
/* 261 */     d /= this.fuelEfficiency;
/* 262 */     this.sum2 += d;
/* 263 */     this.bd = new BigDecimal(d * this.fuelEfficiency);
/* 264 */     this.bd = this.bd.setScale(1, RoundingMode.HALF_UP);
/* 265 */     this.be = new BigDecimal(this.sum2 * this.fuelEfficiency);
/* 266 */     this.be = this.be.setScale(1, RoundingMode.HALF_UP);
/* 267 */     int i = (int)d;
/* 268 */     if (d > this.gas) {
/* 269 */       System.out.println("");
/* 270 */       System.out.println("燃料が不足しています。");
/* 271 */       System.out.print("ガソリンを入れますか？ はい/1 いいえ/2 =");
/* 272 */       Scanner scanner = new Scanner(System.in);
/* 273 */       int j = scanner.nextInt();
/* 274 */       if (j == 1)
/*     */         while (true) {
/* 276 */           System.out.println("");
/* 277 */           System.out.println("ガソリン量を決めてね");
/* 278 */           Scanner scanner1 = new Scanner(System.in);
/* 279 */           double d1 = scanner1.nextDouble();
/* 280 */           if (this.gas + d1 > this.fuelTank) {
/* 281 */             System.out.println("");
/* 282 */             System.out.println("タンク以上のガソリンです。");
/*     */           } 
/* 284 */           if (this.gas + d1 <= this.fuelTank) {
/* 285 */             getfuel(d1);
/*     */             break;
/*     */           } 
/*     */         }  
/* 290 */       if (j == 2) {
/* 291 */         System.out.println("");
/* 292 */         System.out.println("ガソリンを入れませんでした。");
/*     */       } 
/*     */     } 
/* 295 */     if (d <= this.gas) {
/* 296 */       this.gas -= d;
/* 297 */       this.bc = new BigDecimal(this.gas);
/* 298 */       this.bc = this.bc.setScale(1, RoundingMode.HALF_UP);
/* 299 */       System.out.println("");
/* 300 */       System.out.println("移動中・・・");
/* 301 */       System.out.println("・・・");
/*     */       try {
/* 303 */         Thread.sleep(1000L);
/* 304 */       } catch (InterruptedException interruptedException) {}
/* 306 */       System.out.println("・・");
/*     */       try {
/* 308 */         Thread.sleep(1000L);
/* 309 */       } catch (InterruptedException interruptedException) {}
/* 311 */       System.out.println("・");
/*     */       try {
/* 313 */         Thread.sleep(1000L);
/* 314 */       } catch (InterruptedException interruptedException) {}
/* 316 */       System.out.println("");
/* 317 */       System.out.println("座標(" + paramDouble1 + "." + paramDouble2 + ")に移動しました。");
/* 318 */       System.out.println("残燃料:" + this.bc + "[L]");
/* 319 */       movefarePrice(d);
/* 320 */       getfarePrice();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void kaki() {
/*     */     try {
/* 327 */       File file = new File("kinmu.txt");
/* 330 */       if (file.exists()) {
/* 333 */         FileReader fileReader = new FileReader(file);
/*     */         int i;
/* 337 */         while ((i = fileReader.read()) != -1)
/* 338 */           System.out.print((char)i); 
/* 342 */         fileReader.close();
/*     */       } else {
/* 345 */         System.out.print("ファイルは存在しません");
/*     */       } 
/* 347 */     } catch (IOException iOException) {
/* 348 */       iOException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }

