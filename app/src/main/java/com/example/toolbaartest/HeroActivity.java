package com.example.toolbaartest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2017/4/10.
 */

public class HeroActivity extends AppCompatActivity {
    public static final String HERO_NAME="hero_name";
    public static final String HERO_IMAGE_ID="hero_image_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);
        Intent intent = getIntent();
        String heroname = intent.getStringExtra(HERO_NAME);
        int heroImageId = intent.getIntExtra(HERO_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView heroImageView = (ImageView) findViewById(R.id.pic_image_view);
        TextView heroContentText = (TextView) findViewById(R.id.hero_content_text);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(heroname);
        Glide.with(this).load(heroImageId).into(heroImageView);
        String heroContent = updataHero(heroname);
        heroContentText.setText(heroContent);

    }
    private String updataHero(String heroname) {
        //StringBuilder heroContent=new StringBuilder();
        String heroContent=heroname;

       if(heroContent.equals("矮人直升机")) {
            heroContent = "奥雷尔，这个出生于采矿之家的矮人，对爆破有着与生俱来的兴趣与天赋。" +
                   "这种超乎常人的天赋在矮人矿工社会中确定了他极高的收入、头衔和声望" +
                   "但是奥雷尔并不像族人那样安份于爆破矿石，他运用自己的技能组合可控炸药与厚重金属，从发动机到飞弹，" +
                   "任何东西都可以轻易地制造出来。他最热衷的事情莫过于将他的发明带到战场上测试，从而使战场变得极度炫目.";

       }else if(heroContent.equals("月之女祭司")){
           heroContent="作为月神Elune庇护下的长老和高等祭司，" +
                   "Mirana Nightshade在近卫军团中就如同那黑暗中的一线光明。" +
                   "她以雨点一般的箭矢和坠落的流星抵挡蜂拥而至的天灾大军，" +
                   "而她神圣的存在，消除了四周友军的疲倦，" +
                   "让他们在战场上的速度得到极大的提升。" +
                   "在必要的时候，她还能以隐形掩护自己和其他伙伴，" +
                   "使她成为重要的支援力量";
       }else if(heroContent.equals("鱼人守卫")){
           heroContent="在大旋涡翻腾的水下被困了千万年后，" +
                   "娜迦族强大的领袖Slardar鱼人守卫从海底深处苏醒并侍奉他强大的恶魔首领--伊利丹怒风。 在燃烧军团入侵以后，他发觉世界正在被混乱主宰，他意识到这正是打败可恨的暗夜精灵的最佳时机。" +
                   "他盲目的狂热支撑着他在战场上战斗到了最后一刻，" +
                   "直到他屈服于致命的伤\n" +
                   "口。拯救唾手可得,当然这是在他的命运和巫妖王纠结在一起以后。重生以后的鱼人守卫已经成为了没有感情的野兽。他以超越常人的速度撕裂敌人，给他们致命一击，从不在耐奥祖的任何命令前退缩。和天灾军团结成同盟以后，Slardar在战斗中以他强大的力量击晕并碾碎对手，他有力的三叉戟能够轻易地切开最厚实的护甲。";
      }else if(heroContent.equals("秀逗魔导师")){
           heroContent="Lina Inverse是一位非常强大的法师，她以打击盗贼（其实是为了他们的财宝）和屠龙（一不小心毁灭了边上的城市）而著称。她能够非常熟练地投掷火球打击对手，当然她还掌握了诸如龙破斩、神灭斩等更具破坏力的法术。Lina承诺帮助近卫军团摧毁冰封王座，当然最主要是为了之后巨额的报酬——强力的武器和非常多的钱";
       }else if(heroContent.equals("矮人火枪手")){
           heroContent="Kardel是近卫军团的狙击专家。由于他超远的射程，总能在很安全的位置给敌人造成十分巨大的伤害" +
                   "十个火枪九个菜，还有一个特别菜”已经成了DOTAer们的口头禅，甚至许多DOTAer们都有“有手选火枪必输”“队友有火枪就秒退”的名言。诚然，火枪确实是许多菜鸟的挚爱，今天就给大家带来矮人火枪手的出装攻略，火枪是一个非常需要技术的英雄，虽然他只有两个控制机，但是好手与菜鸟对于这个英雄的掌控所给团队带来的贡献差别太大了";
       }else if(heroContent.equals("剑圣")){
           heroContent="    “虽万人众，吾往矣”\n" +
                   "    “仗剑天下,傲剑凌云”\n" +
                   "    “剑圣”，一个没有太多传奇色彩的名字，却让我们深深感动、尊敬、迷恋、甚至崇拜.\n" +
                   "他出剑似舞蹈般灵动轻盈，无论多坚固的护甲都已悄然破碎：他行动如诗歌般优雅从容，无论多强的敌人弹指间灰飞烟灭。是的，Yurnero追求完美，追求人剑合一的至高境界，成为那无人能敌的剑圣便是他的宿命。njhg"
           ;
       }else if(heroContent.equals("召唤师")){
           heroContent="Quas,Wex,Exort. 风暴的精华。 暴风雪之心。 凤凰的灵魂。在他的子民们分崩离析到世界的各个角落去之后，Kael被遗弃了，陪伴他的是他曾经创造的的大世界仅存的遗物。对复仇的渴望，让他将自己的灵魂出卖给了耐奥祖，交换来的是近乎无限的力量。披上古代血法师的斗篷，创世者只带着他支配的元素跨入了这场战争。他能够将元素熔合成致命的咒语，在狂怒中撕裂天空。他的天才无穷无尽，近卫军团将会体会到创世者的愤怒。召唤师拥有10个不同的技能却没有属性点，这在Dota英雄中的独一无二的。这也正是一些新手玩家认为这个英雄难以上手、不好使，而高手们反而认为此英雄颇具潜力的原因。当提到这个英雄时，你可能会把他想成是“鸡尾酒”，三种“口味”供你选择。";
       }else if(heroContent.equals("半人猛犸")){
           heroContent="也许是天灾军团中最巨型生物的缘故，Magnus的力量让人难以招架。他从出生以来就一直为了成为强力的战士而磨炼着。而现在，他已到达了他力量的颠峰。他的巨斧不但能从他的敌人中劈开血路，而且还能发出碎骨冲击，让大地产生波纹。更厉害的是，他的攻击可以通过恶魔魔力的强化，从而轻而易举地粉碎敌人。尽管如此，他最强的能力还是在于他能够产生一个宽阔而且强力的磁场，将那些软弱的敌人吸到一块儿，然后去面对他们生命的尽头。";
       }else if(heroContent.equals("痛苦女王")){
           heroContent="厄泽王庭的教皇有个隐秘的受虐癖——以品尝禁忌之痛为乐。即便是对那些普通政客而言这都是愚蠢至极的，而对于教皇而言，这种私欲已经威胁到了神权本身的纯洁和完整。于是他只好偷偷的去他的地牢里，求助于那一帮恶魔学识大师，承诺只要有人召唤一名完全为他服务的痛苦女妖，那就能获得自由。旋即魔女降世，名为阿卡莎，她给教皇带去了无与伦比的痛苦和刺激，教皇随即赐其隐秘皇后之位，并将所有闲暇时间用于享受她带来的花样百出的痛苦——最终，为了追求这种只有阿卡莎能带给他的痛苦，教皇放弃了他的所有职责。\n" +
                   "痛苦女王能让他体验濒死之欢愉，并因为受符文的限制而无法杀死他。终于，教皇的不理朝政引发了起义，他被愤怒的人们从密室里拖出来，然后从祈灵塔上扔了下去。然而，他的死亡却让痛苦女王获得了自由，不再被奴役，她将恣意的向世界挥洒她的痛苦";
       }else if(heroContent.equals("影魔")){
           heroContent="Nevermore是一种能吸收身体周围的灵魂的生物。他虽然是来自燃烧军团的魔鬼，但是却讨厌和同类的魔鬼一样蠕动，于是便重新伪装了自己。当影魔投入到战斗的时候，便能通过吸收灵魂来增强自己的力量，还能用他被灵魂增强过的攻击以及强力的精神冲击去击败对手。在遭遇过他的少数幸存者的心目中，影魔是最恐怖的对手，而那些被他残暴地杀死的人，才算见识过什么是世界上最卑鄙的杀人手段。";
       }else if(heroContent.equals("神灵武士")){
           heroContent="神灵武士：Huskar，圣灵，神灵 暗矛部落的巨魔们在很久以前就被从位于荆棘谷的原住地流放出来。他们是大多数人眼中最野蛮的种族，与他们相比，甚至连战场都显得优雅起来。这个“美誉”，更因他们在近卫军团的代表，那个为了将敌人烧成碎片而不惜燃烧自己生命的Huskar，而名声大噪。在他的族人眼里，身为神灵武士的他，是被神祝福的烈士，不畏死亡，永远向前，甚至是疯狂的，誓要将不死天灾拖入坟墓。";
       }else{
          heroContent="暂未更新....";
        }

        return heroContent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
