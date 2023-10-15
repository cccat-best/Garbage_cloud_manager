/*************笔记****************
1、CubeMX 定义任意一个引脚，作为数据脚，并对引脚作出如下配置：
   GPlO output level       －－High
   GPIO mode               －－Output Open Drain
   GPIO Pull-up/Pull-down  －－No pull-up and no pull-down
   Maximum output speed    －－LOW
   User label              －－DHT11
2、MQ2烟雾报警模块的引号引脚为PA5
   本设计采用TTL输出（即高低电平）  低电平--差  高电平--良好
***********************************/
#include "main.h"
#include "mq2.h"
#include "stdio.h"
/******************
函数名：Mq2_State
功能：获取MQ2烟雾报警模块的状态
*******************/
uint8_t flg = 0;


void Mq2_State(void)
{
    if(HAL_GPIO_ReadPin(mq2_GPIO_Port, mq2_Pin) == GPIO_PIN_RESET) //读取引脚电平是否为低电平
    {
        printf("空气质量差！\r\n");
			  flg = 1;
			
    }
    else
    {
        printf("空气质量不错！\r\n");
			  flg = 0;
    }
}

