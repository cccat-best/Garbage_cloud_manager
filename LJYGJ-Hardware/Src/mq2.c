/*************�ʼ�****************
1��CubeMX ��������һ�����ţ���Ϊ���ݽţ��������������������ã�
   GPlO output level       ����High
   GPIO mode               ����Output Open Drain
   GPIO Pull-up/Pull-down  ����No pull-up and no pull-down
   Maximum output speed    ����LOW
   User label              ����DHT11
2��MQ2������ģ�����������ΪPA5
   ����Ʋ���TTL��������ߵ͵�ƽ��  �͵�ƽ--��  �ߵ�ƽ--����
***********************************/
#include "main.h"
#include "mq2.h"
#include "stdio.h"
/******************
��������Mq2_State
���ܣ���ȡMQ2������ģ���״̬
*******************/
uint8_t flg = 0;


void Mq2_State(void)
{
    if(HAL_GPIO_ReadPin(mq2_GPIO_Port, mq2_Pin) == GPIO_PIN_RESET) //��ȡ���ŵ�ƽ�Ƿ�Ϊ�͵�ƽ
    {
        printf("���������\r\n");
			  flg = 1;
			
    }
    else
    {
        printf("������������\r\n");
			  flg = 0;
    }
}

