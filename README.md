# fragment_demo

   * 总结了几种fragment加载方式，目前来说viewpage消耗最小，比较合适
   * replace适合取代类型的，其他的显隐自己根据需求使用
   此次使用viewpage,和fragment的show，hide,replace,popBackStack
   
   
   
   
   有关于lambda表达式的处理
        compileOptions {
        targetCompatibility 1.8
        sourceCompatibility 1.8
    }
   apply plugin: 'me.tatarka.retrolambda'
   classpath'me.tatarka:gradle-retrolambda:3.2.5'
   
   
   activtiy切换动画黑屏问题的处理
