package com.fh.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * User: guangtou
 * Date: 2018/6/23 20:22
 */
@Data
@NoArgsConstructor
public class Detect {


    /**
     * 检验记录单
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class detectRecord {
        String dsId; // 检验检测机构唯一编 码，见附录B
        String dsName; //检验检测机构名称
        String detectSn; //检测流水号,见附录 B.7
        String detectType; //检测类别
        String detectDate; //检测日期: YYYY-MM-DD hh:mm:ss
        String client; //委托人
        String vehicleNo; //车牌号码
        String plateColorCode; //车牌颜色代码，见附录 B.3
        String vinNo; //车辆识别代码
        String vehicleType;//车辆类型:参照GA 24.4
        String engineNo; //发动机号码
        BigDecimal travelMileage;//行驶总里程，单位km
        String fuelType;//燃油类别，参照JT/T 697.7
        BigDecimal steeringAxleAmount;//转向轴数，单位:轴
        String detectLine;//检测线别:规定值:大写英文字母
        String busiType;//业务类型:规定值:申请、在用

        BigDecimal seatCount;//座位(铺)数，单位: 位，客车必填，货车非 必填
        BigDecimal detectTotalCount;//    总检次数，单位:次


        /**
         * 下面为非必填
         */

        String transCertificateCode;//道路运输证号
        String trailerVehicleNo; //挂车牌照号码
        String trailerVehicleType;//挂车类型，参照GB/T 3730.2
        String productionDate;//出厂日期: YYYYMMDD
        String registDate;//注册日期:YYYYMMDD
        String vehicleBrandModel;//车辆型号:参照JT/T 697.7
        String vehicleBodyColor;//车身颜色，见附录B.2
        String driveType;//驱动型式，如:4×2后 驱
        String vehicleSuspensionForm;//否 车辆悬架形式，参照 JT/T 697.7
        BigDecimal trailerVehicleAxleAmount;//数字型N8否 挂车轴数，单位:轴
        BigDecimal compressIgnitEnginePower;//数字型N8,2 否 压燃式发动机额定功 率，单位:kW
        BigDecimal ratedTorque;//数字型N8,2 点燃式额定扭矩
        BigDecimal ratedSpeedOfIgnit;//数字型N8,2 点燃式额定转速
        BigDecimal driveWheelModel;// 驱动轮轮胎规格型号
        BigDecimal totalWeight;//数字型N8,2 总质量，单位:kg
        BigDecimal vehicleHeight;//数字型N8 车高，单位:mm
        BigDecimal frontTrack;//数字型N8否 前轮距，单位:mm
        BigDecimal vehicleLength;//数字型N8否 客车车长，单位:mm
        String busTypeLevel;//客车类型与等级，参照 JT/T 697.7

        String truckBodyType;//货车车身型式
        BigDecimal driveAxleAmount;//驱动轴数，单位:轴
        BigDecimal driveAxleLoadMass;//驱动轴空载质量，单 位:kg
        BigDecimal totalWeightOfTractor;//牵引车满载总质量(最 大允许总质量)，单 位:kg
        String shaftForm;//并装轴形式，如:并装 双轴、并装三轴等
        String lampSystem;//前照灯制，规定值:二、 四
        BigDecimal mainVehicleAxleAmount;//单车(主车)轴数
        String overallSize;//单车外廓尺寸，格式: 长×宽×高，单位:mm
        String overallSizeTrailer;//挂车外廓尺寸，格式: 长×宽×高，单位:mm
        String farLightCanAdjust;//远光束能否单独调整
        String parkAxle;//驻车轴，用数字表示， 作用在多轴时，各驻车 轴数用“,”分开
        BigDecimal carriageSsideboardHeight;//单车车厢栏板高度，单 位:mm
        BigDecimal ssideboardHeightTrailer;//挂车车厢栏板高度，单 位:mm


        /**
         * 动力性节点
         */
        @Data
        @NoArgsConstructor


        class power {


            BigDecimal standardPower;//达标功率，单位:kW
            BigDecimal ratedSpeed;//额定车速，单位:km/h
            BigDecimal loadingForce;//加载力，单位:N

            BigDecimal steadySpeed;//稳定车速，单位:km/h
            BigDecimal evaluate;//判定:见附录B.8

        }

        /**
         * 燃料经济性
         */
        @Data
        @NoArgsConstructor


        class fuelEconomy {
            BigDecimal speedFuelPerHundredKm;//等速百公里油耗标准 限值
            BigDecimal measuredValue;//实测值
            String evaluate;//判定:见附录B.8
        }


        /**
         * 制动性
         */
        @Data
        @NoArgsConstructor

        class brake {

            /**
             * 原始数据
             */
            @Data
            @NoArgsConstructor
    
            class initData {

                BigDecimal axleSerialNo;// 轴序号(第几轴)， 规定 值:1、2、3、4、5、6
                BigDecimal leftHorizontalLoadWheel;// 水平称重轮荷(左轮)，单位: daN
                BigDecimal rightHorizontalLoadWheel;// 水平称重轮荷(右轮)，单位: daN
                BigDecimal axleLoadOfCompoundTable;// 复合台称重轴荷，单位: daN
                BigDecimal leftDynamicWheelLoad;// 动态轮荷(左轮)，单位: daN
                BigDecimal rightDynamicWheelLoad;// 动态轮荷(右轮)，单位: daN
                BigDecimal leftDriveBrakeForce;// 行车制动力(左轮)，单位:daN

                BigDecimal rightDriveBrakeForce;// 行车制动力(右轮)， 单位:daN
                BigDecimal leftParkBrakeForce;//驻车制动力(左轮)， 单位:daN
                BigDecimal rightParkBrakeForce;// 驻车制动力(右轮)， 单位:daN

            }

            /**
             * 整车
             */
            @Data
            @NoArgsConstructor
    
            class wholeVehicle {

                /**
                 * 单车
                 */
                @Data
                @NoArgsConstructor
        
                class singleVehicle {
                    BigDecimal horizontalWeight;// 水平称重，单位:daN
                    BigDecimal wholeVehicleBrakeRate;// 整车制动率，单位:%
                    BigDecimal parkBrakeRate;//驻车制动率，单位:%
                    String evaluate;// 判定:见附录B.8
                }

                /**
                 * 汽车列车项目第1部分
                 */
                @Data
                @NoArgsConstructor
        
                class vehicleSerial1 {
                    BigDecimal horizontalWeight;// 水平称重，单位:daN
                    BigDecimal vehicleBrakeRateTractor;// 整车制动率(牵)， 单位:%
                    BigDecimal vehicleBrakeRateTrailer;// 整车制动率(挂)， 单位:%
                    BigDecimal parkBrakeRate;// 驻车制动率，单位:%
                    BigDecimal brakeCoordinateTime;// 制动协调时间，单位: s
                    String evaluate;// 判定:见附录B.8
                }

                /**
                 * 制动时序(时 间)
                 */
                @Data
                @NoArgsConstructor
        
                class brakeSeqTime {
                    BigDecimal axle1;//轴1，单位:s
                    BigDecimal axle2;//轴1，单位:s
                    BigDecimal axle3;//轴1，单位:s
                    BigDecimal axle4;//轴1，单位:s
                    BigDecimal axle5;//轴1，单位:s
                    BigDecimal axle6;//轴1，单位:s
                    String evaluate;// 判定:见附录B.8
                }

                /**
                 * 制动时序(时 序)
                 */
                @Data
                @NoArgsConstructor
        
                class brakeSeq {
                    String axle1;//轴1，规定值:1、2、3、 4、5、6
                    String axle2;//轴1，规定值:1、2、3、 4、5、6
                    String axle3;//轴1，规定值:1、2、3、 4、5、6
                    String axle4;//轴1，规定值:1、2、3、 4、5、6
                    String axle5;//轴1，规定值:1、2、3、 4、5、6
                    String axle6;//轴1，规定值:1、2、3、 4、5、6
                    String evaluate;// 判定:见附录B.8
                }

                /**
                 * 汽车列车项目第2部分
                 */
                @Data
                @NoArgsConstructor
        
                class vehicleSerial2 {
                    BigDecimal brakeRateTractorTrain;//整车制动率比 %(牵引 车/列车)，单位:%
                    BigDecimal brakeRateTrailerTrain;//整车制动率比 %(挂车 /列车)，单位:%
                    String evaluate;// 判定:见附录B.8
                }
            }


            /**
             * 单轴
             */
            @Data
            @NoArgsConstructor
    
            class singleAxle {

                BigDecimal axleSerialNo; //轴序号(第几轴)，规定 值:1、2、3、4、5、6
                BigDecimal axleBrakeRate; //轴制动率，单位:%

                BigDecimal brakeUnbalanceRate;//制动不平衡率， 单位:%
                BigDecimal leftMaxProcessDiff;//过程差最大点(左轮)， 单位:daN
                BigDecimal rightMaxProcessDiff;// 过程差最大点(右轮)， 单位:daN
                BigDecimal leftRetardingForce;//车轮阻滞率(左轮)， 单位:%
                BigDecimal rightRetardingForce;// 车轮阻滞率(右轮)， 单位:%
                String evaluate;//判定，见附录B.8
            }

            /**
             * 路试
             */
            @Data
            @NoArgsConstructor
    
            class roadTest {
                /**
                 * 行车制动
                 */
                @Data
                @NoArgsConstructor
        
                class driveBrake {
                    BigDecimal initialVelocity;// 初速度，单位:km/h
                    BigDecimal laneWidth;// 试车道宽度，单位:m
                    BigDecimal brakeDistance;// 制动距离，单位:m
                    BigDecimal mfdd;// MFDD，单位:m/s2
                    String brakeStability;// 制动稳定性，规定值: 稳定、不稳定
                    BigDecimal brakeCoordinateTime;// 汽车列车制动协调时 间，单位:s
                    String evaluate;// 判定，见附录B.8
                }

                /**
                 * 驻车制动
                 */
                @Data
                @NoArgsConstructor
        
                class parkBrake {
                    BigDecimal parkSlope;// 驻车坡度，单位:%
                    String parkResult;// 不少于5 min坡道驻车 情况，规定值:溜坡、 不溜坡
                    String evaluate;// 判定，见附录B.8
                }
            }
        }


        /**
         * 排放性
         */
        @Data
        @NoArgsConstructor

        class emission {

            /**
             * 汽油车
             */
            @Data
            @NoArgsConstructor
    
            class gasolineVehicle {
                BigDecimal highCo;//CO_高怠速，单位:%
                BigDecimal highHc;//HC_高怠速，单位:10-6
                BigDecimal highL;//λ_高怠速
                BigDecimal lowCo;//CO_怠速，单位:%
                BigDecimal lowHc;//HC_怠速，单位:10-6
                BigDecimal co5025;//CO_5025，单位:%
                BigDecimal hc5025;//HC_5025，单位:10-6
                BigDecimal no5025;//NO_5025，单位:10-6
                BigDecimal co2540;//CO_2540，单位:%
                BigDecimal hc2540;//HC_2540，单位:10-6
                BigDecimal no2540;//NO_2540，单位:10-6
                BigDecimal vmasCo;//CO_简易瞬态工况， 单位:g/km
                BigDecimal vmasHc;//HC_简易瞬态工况， 单位:g/km
                BigDecimal vmasNo;//NO_简易瞬态工况， 单位:g/km
                BigDecimal vmasHcNo;//HC_NO_简易瞬态工况， 单位:g/km
                String evaluate;// 判定，见附录B.8
            }

            /**
             * 柴油车
             */
            @Data
            @NoArgsConstructor
    
            class dieselVehicle {
                BigDecimal ratio1;//光吸收系数1， 单位:m-1
                BigDecimal ratio2;//光吸收系数1， 单位:m-1
                BigDecimal ratio3;//光吸收系数1， 单位:m-1
                BigDecimal ratioBalance;//光吸收系数平均， 单位:m-1
                BigDecimal smoke1;//滤纸烟度1，单位:BSU
                BigDecimal smoke2;//滤纸烟度2，单位:BSU
                BigDecimal smoke3;//滤纸烟度3，单位:BSU
                BigDecimal smokeBalance;//滤纸烟度平均， 单位:BSU
                BigDecimal ratio100;//光吸收系数100%， 单位:m-1
                BigDecimal ratio90;//光吸收系数90%， 单位:m-1
                BigDecimal ratio80;//光吸收系数80%， 单位:m-1
                BigDecimal maxWheelSideP;//实测最大轮边功率， 单位:kW
                String evaluate;// 判定，见附录B.8
            }

            /**
             * 悬架
             */
            @Data
            @NoArgsConstructor
    
            class suspension {
                String axleType;//轴类型，规定值:前轴、 后轴
                BigDecimal efficiencyOfLeftAxle;//左吸收率，单位:%
                BigDecimal efficiencyOfRightAxle;//右吸收率，单位:%
                BigDecimal absorbRateDifOfAxle;//左右差，单位:%
                String evaluate;//判定，见附录B.8
            }

            /**
             * 前照灯
             */
            @Data
            @NoArgsConstructor
    
            class mainLamp {
                String axleType;//灯类型，见附录B.9

                BigDecimal nearLightLamp;//灯高(近光)， 单位:mm
                BigDecimal farLightLampHight;//灯高(远光)， 单位:mm
                BigDecimal farLightStrong;//远光光强，单位:cd
                BigDecimal farLightVOffset;//远光偏移(垂直)， 单位:H
                BigDecimal farLightHOffset;//远光偏移(水平)， 单位:mm/10m
                BigDecimal nearLightVOffset;//近光偏移(垂直)， 单位:H
                BigDecimal nearLightHOffset;//近光偏移(水平)， 单位:mm/10m
                String evaluate;//判定，见附录B.8
            }


            /**
             * 单项检测
             */
            @Data
            @NoArgsConstructor
    
            class singleItem {

                String itemCode;//单项检测项目编码,见 附录B.10

            }


        }
    }

    /**
     * 图片资料
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class image {
        String imageUrl;//图片链接地址
        String imageType;//检验工位照片类型,见 附录B.11
    }

    /**
     * 图片资料
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class video {
        String videoUrl;//图片链接地址
        String videoType;//检验工位照片类型,见 附录B.11
    }

    /**
     * 检验报告单
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class detectReport {

        String detectResult;//检验结论:一级、二级、 三级或合格、不合格
        String note;//备注

        /**
         * 单车(牵引车)基本信 息
         */
        @Data
        @NoArgsConstructor

        class tractorInfo {
            String vehicleNo;// 号牌号码
            String vinNo;// 车辆识别代码
            String engineNo;// 发动机号码
            String client;// 委托人
            String vehicleBrandModel;// 厂牌型号，参照JT/T 697.7
            String administrativeAera;// 行政区划代码，参照 GB/T 2260
            String vehicleType;// 车辆类型:参照GA 24.4
            String transCertificateCode;// 道路运输证号
            String registDate;// 注册登记日期，车辆行 驶证初领日期: YYYYMMDD
            String productionDate;// 出厂年月: YYYYMMDD
            String driveLicense;// 机动车行驶证号
            String vehicleBodyColor;// 车身颜色,见附录B.2
        }

        /**
         * 号牌号码
         */
        @Data
        @NoArgsConstructor

        class trailerInfo {
            String vehicleNo;//号牌号码
            String client;//委托人
            String vehicleType;//车辆类型:参照GA 24.4
            String vehicleBrandModel;//厂牌型号，参照JT/T 697.7
            String transCertificateCode;//道路运输证号

            String registDate;//注册登记日期: YYYYMMDD
            String productionDate;//出厂日期: YYYYMMDD
            String vinNo;//车辆识别代码
            String driveLicense;//车辆行驶证号
        }

        /**
         * 人工检验结果
         */
        class manualTestResult {
            String detectCls;//人工检验项目代码，见 附录B.13
            String evaluate;//判定:见附录B.8
            String unqualifiedItem;//不符合项目
        }

        /**
         * 性能检测
         */
        @Data
        @NoArgsConstructor

        class performanceItem{
            String itemCode ;//性能检测项目编码，见 附B.14
            String detectData ;//检测数据，各项格式参 照GB 18565
            String standardValue ;//标准限值，各项格式参 照GB 18565
            String evaluate ;//判定:见附录B.8
        }
    }


}
