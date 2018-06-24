package com.fh.demo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.math.BigDecimal;

/**
 * User: guangtou
 * Date: 2018/6/24 13:59
 */
@Data
public class DetectInfo {
    public static void main(String[] args) {
        DetectInfo a = new DetectInfo();
        a.setDsId(new String("1")); // 检验检测机构唯一编 码，见附录B
        a.setDsName(new String("1")); //检验检测机构名称
        a.setDetectSn(new String("1")); //检测流水号,见附录 B.7
        a.setDetectType(new String("1")); //检测类别
        a.setDetectDate(new String("1")); //检测日期: YYYY-MM-DD hh:mm:ss
        a.setClient(new String("1")); //委托人
        a.setVehicleNo(new String("1")); //车牌号码
        a.setPlateColorCode(new String("1")); //车牌颜色代码，见附录 B.3
        a.setVinNo(new String("1")); //车辆识别代码
        a.setVehicleType(new String("1"));//车辆类型:参照GA 24.4
        a.setEngineNo(new String("1")); //发动机号码
        a.setTravelMileage(new BigDecimal(1));//行驶总里程，单位km
        a.setFuelType(new String("1"));//燃油类别，参照JT/T 697.7
        a.setSteeringAxleAmount(new BigDecimal(1));//转向轴数，单位:轴
        a.setDetectLine(new String("1"));//检测线别:规定值:大写英文字母
        a.setBusiType(new String("1"));//业务类型:规定值:申请、在用
        a.setSeatCount(new BigDecimal(1));//座位(铺)数，单位: 位，客车必填，货车非 必填
        a.setDetectTotalCount(new BigDecimal(1));//    总检次数，单位:次
        a.setTransCertificateCode(new String("1"));//道路运输证号
        a.setTrailerVehicleNo(new String("1")); //挂车牌照号码
        a.setTrailerVehicleType(new String("1"));//挂车类型，参照GB/T 3730.2
        a.setProductionDate(new String("1"));//出厂日期: YYYYMMDD
        a.setRegistDate(new String("1"));//注册日期:YYYYMMDD
        a.setVehicleBrandModel(new String("1"));//车辆型号:参照JT/T 697.7
        a.setVehicleBodyColor(new String("1"));//车身颜色，见附录B.2
        a.setDriveType(new String("1"));//驱动型式，如:4×2后 驱
        a.setVehicleSuspensionForm(new String("1"));//否 车辆悬架形式，参照 JT/T 697.7
        a.setTrailerVehicleAxleAmount(new BigDecimal(1));//数字型N8否 挂车轴数，单位:轴
        a.setCompressIgnitEnginePower(new BigDecimal(1));//数字型N8,2 否 压燃式发动机额定功 率，单位:kW
        a.setRatedTorque(new BigDecimal(1));//数字型N8,2 点燃式额定扭矩
        a.setRatedSpeedOfIgnit(new BigDecimal(1));//数字型N8,2 点燃式额定转速
        a.setDriveWheelModel(new BigDecimal(1));// 驱动轮轮胎规格型号
        a.setTotalWeight(new BigDecimal(1));//数字型N8,2 总质量，单位:kg
        a.setVehicleHeight(new BigDecimal(1));//数字型N8 车高，单位:mm
        a.setFrontTrack(new BigDecimal(1));//数字型N8否 前轮距，单位:mm
        a.setVehicleLength(new BigDecimal(1));//数字型N8否 客车车长，单位:mm
        a.setBusTypeLevel(new String("1"));//客车类型与等级，参照 JT/T 697.7
        a.setTruckBodyType(new String("1"));//货车车身型式
        a.setDriveAxleAmount(new BigDecimal(1));//驱动轴数，单位:轴
        a.setDriveAxleLoadMass(new BigDecimal(1));//驱动轴空载质量，单 位:kg
        a.setTotalWeightOfTractor(new BigDecimal(1));//牵引车满载总质量(最 大允许总质量)，单 位:kg
        a.setShaftForm(new String("1"));//并装轴形式，如:并装 双轴、并装三轴等
        a.setLampSystem(new String("1"));//前照灯制，规定值:二、 四
        a.setMainVehicleAxleAmount(new BigDecimal(1));//单车(主车)轴数
        a.setOverallSize(new String("1"));//单车外廓尺寸，格式: 长×宽×高，单位:mm
        a.setOverallSizeTrailer(new String("1"));//挂车外廓尺寸，格式: 长×宽×高，单位:mm
        a.setFarLightCanAdjust(new String("1"));//远光束能否单独调整
        a.setParkAxle(new String("1"));//驻车轴，用数字表示， 作用在多轴时，各驻车 轴数用“,”分开
        a.setCarriageSsideboardHeight(new BigDecimal(1));//单车车厢栏板高度，单 位:mm
        a.setSsideboardHeightTrailer(new BigDecimal(1));//挂车车厢栏板高度，单 位:mm
        a.setPower_standardPower(new BigDecimal(1));//达标功率，单位:kW
        a.setPower_ratedSpeed(new BigDecimal(1));//额定车速，单位:km/h
        a.setPower_loadingForce(new BigDecimal(1));//加载力，单位:N
        a.setPower_steadySpeed(new BigDecimal(1));//稳定车速，单位:km/h
        a.setPower_evaluate(new BigDecimal(1));//判定:见附录B.8
        a.setFuelEconomy_speedFuelPerHundredKm(new BigDecimal(1));//等速百公里油耗标准 限值
        a.setFuelEconomy_measuredValue(new BigDecimal(1));//实测值
        a.setFuelEconomy_evaluate(new String("1"));//判定:见附录B.8
        a.setInitData_axleSerialNo(new BigDecimal(1));// 轴序号(第几轴)， 规定 值:1、2、3、4、5、6
        a.setInitData_leftHorizontalLoadWheel(new BigDecimal(1));// 水平称重轮荷(左轮)，单位: daN
        a.setInitData_rightHorizontalLoadWheel(new BigDecimal(1));// 水平称重轮荷(右轮)，单位: daN
        a.setInitData_axleLoadOfCompoundTable(new BigDecimal(1));// 复合台称重轴荷，单位: daN
        a.setInitData_leftDynamicWheelLoad(new BigDecimal(1));// 动态轮荷(左轮)，单位: daN
        a.setInitData_rightDynamicWheelLoad(new BigDecimal(1));// 动态轮荷(右轮)，单位: daN
        a.setInitData_leftDriveBrakeForce(new BigDecimal(1));// 行车制动力(左轮)，单位:daN
        a.setInitData_rightDriveBrakeForce(new BigDecimal(1));// 行车制动力(右轮)， 单位:daN
        a.setInitData_leftParkBrakeForce(new BigDecimal(1));//驻车制动力(左轮)， 单位:daN
        a.setInitData_rightParkBrakeForce(new BigDecimal(1));// 驻车制动力(右轮)， 单位:daN
        a.setSingleVehicle_horizontalWeight(new BigDecimal(1));// 水平称重，单位:daN
        a.setSingleVehicle_wholeVehicleBrakeRate(new BigDecimal(1));// 整车制动率，单位:%
        a.setSingleVehicle_parkBrakeRate(new BigDecimal(1));//驻车制动率，单位:%
        a.setSingleVehicle_evaluate(new String("1"));// 判定:见附录B.8
        a.setVehicleSerial1_horizontalWeight(new BigDecimal(1));// 水平称重，单位:daN
        a.setVehicleSerial1_vehicleBrakeRateTractor(new BigDecimal(1));// 整车制动率(牵)， 单位:%
        a.setVehicleSerial1_vehicleBrakeRateTrailer(new BigDecimal(1));// 整车制动率(挂)， 单位:%
        a.setVehicleSerial1_parkBrakeRate(new BigDecimal(1));// 驻车制动率，单位:%
        a.setVehicleSerial1_brakeCoordinateTime(new BigDecimal(1));// 制动协调时间，单位: s
        a.setVehicleSerial1_evaluate(new String("1"));// 判定:见附录B.8
        a.setBrakeSeqTime_axle1(new BigDecimal(1));//轴1，单位:s
        a.setBrakeSeqTime_axle2(new BigDecimal(1));//轴1，单位:s
        a.setBrakeSeqTime_axle3(new BigDecimal(1));//轴1，单位:s
        a.setBrakeSeqTime_axle4(new BigDecimal(1));//轴1，单位:s
        a.setBrakeSeqTime_axle5(new BigDecimal(1));//轴1，单位:s
        a.setBrakeSeqTime_axle6(new BigDecimal(1));//轴1，单位:s
        a.setBrakeSeqTime_evaluate(new String("1"));// 判定:见附录B.8
        a.setBrakeSeq_axle1(new String("1"));//轴1，规定值:1、2、3、 4、5、6
        a.setBrakeSeq_axle2(new String("1"));//轴1，规定值:1、2、3、 4、5、6
        a.setBrakeSeq_axle3(new String("1"));//轴1，规定值:1、2、3、 4、5、6
        a.setBrakeSeq_axle4(new String("1"));//轴1，规定值:1、2、3、 4、5、6
        a.setBrakeSeq_axle5(new String("1"));//轴1，规定值:1、2、3、 4、5、6
        a.setBrakeSeq_axle6(new String("1"));//轴1，规定值:1、2、3、 4、5、6
        a.setBrakeSeq_evaluate(new String("1"));// 判定:见附录B.8
        a.setVehicleSerial2_brakeRateTractorTrain(new BigDecimal(1));//整车制动率比 %(牵引 车/列车)，单位:%
        a.setVehicleSerial2_brakeRateTrailerTrain(new BigDecimal(1));//整车制动率比 %(挂车 /列车)，单位:%
        a.setVehicleSerial2_evaluate(new String("1"));// 判定:见附录B.8
        a.setSingleAxle_axleSerialNo(new BigDecimal(1)); //轴序号(第几轴)，规定 值:1、2、3、4、5、6
        a.setSingleAxle_axleBrakeRate(new BigDecimal(1)); //轴制动率，单位:%
        a.setSingleAxle_brakeUnbalanceRate(new BigDecimal(1));//制动不平衡率， 单位:%
        a.setSingleAxle_leftMaxProcessDiff(new BigDecimal(1));//过程差最大点(左轮)， 单位:daN
        a.setSingleAxle_rightMaxProcessDiff(new BigDecimal(1));// 过程差最大点(右轮)， 单位:daN
        a.setSingleAxle_leftRetardingForce(new BigDecimal(1));//车轮阻滞率(左轮)， 单位:%
        a.setSingleAxle_rightRetardingForce(new BigDecimal(1));// 车轮阻滞率(右轮)， 单位:%
        a.setSingleAxle_evaluate(new String("1"));//判定，见附录B.8
        a.setDriveBrake_initialVelocity(new BigDecimal(1));// 初速度，单位:km/h
        a.setDriveBrake_laneWidth(new BigDecimal(1));// 试车道宽度，单位:m
        a.setDriveBrake_brakeDistance(new BigDecimal(1));// 制动距离，单位:m
        a.setDriveBrake_mfdd(new BigDecimal(1));// MFDD，单位:m/s2
        a.setDriveBrake_brakeStability(new String("1"));// 制动稳定性，规定值: 稳定、不稳定
        a.setDriveBrake_brakeCoordinateTime(new BigDecimal(1));// 汽车列车制动协调时 间，单位:s
        a.setDriveBrake_evaluate(new String("1"));// 判定，见附录B.8
        a.setParkBrake_parkSlope(new BigDecimal(1));// 驻车坡度，单位:%
        a.setParkBrake_parkResult(new String("1"));// 不少于5 min坡道驻车 情况，规定值:溜坡、 不溜坡
        a.setParkBrake_evaluate(new String("1"));// 判定，见附录B.8
        a.setGasolineVehicle_highCo(new BigDecimal(1));//CO_高怠速，单位:%
        a.setGasolineVehicle_highHc(new BigDecimal(1));//HC_高怠速，单位:10-6
        a.setGasolineVehicle_highL(new BigDecimal(1));//λ_高怠速
        a.setGasolineVehicle_lowCo(new BigDecimal(1));//CO_怠速，单位:%
        a.setGasolineVehicle_lowHc(new BigDecimal(1));//HC_怠速，单位:10-6
        a.setGasolineVehicle_co5025(new BigDecimal(1));//CO_5025，单位:%
        a.setGasolineVehicle_hc5025(new BigDecimal(1));//HC_5025，单位:10-6
        a.setGasolineVehicle_no5025(new BigDecimal(1));//NO_5025，单位:10-6
        a.setGasolineVehicle_co2540(new BigDecimal(1));//CO_2540，单位:%
        a.setGasolineVehicle_hc2540(new BigDecimal(1));//HC_2540，单位:10-6
        a.setGasolineVehicle_no2540(new BigDecimal(1));//NO_2540，单位:10-6
        a.setGasolineVehicle_vmasCo(new BigDecimal(1));//CO_简易瞬态工况， 单位:g/km
        a.setGasolineVehicle_vmasHc(new BigDecimal(1));//HC_简易瞬态工况， 单位:g/km
        a.setGasolineVehicle_vmasNo(new BigDecimal(1));//NO_简易瞬态工况， 单位:g/km
        a.setGasolineVehicle_vmasHcNo(new BigDecimal(1));//HC_NO_简易瞬态工况， 单位:g/km
        a.setGasolineVehicle_evaluate(new String("1"));// 判定，见附录B.8
        a.setDieselVehicle_ratio1(new BigDecimal(1));//光吸收系数1， 单位:m-1
        a.setDieselVehicle_ratio2(new BigDecimal(1));//光吸收系数1， 单位:m-1
        a.setDieselVehicle_ratio3(new BigDecimal(1));//光吸收系数1， 单位:m-1
        a.setDieselVehicle_ratioBalance(new BigDecimal(1));//光吸收系数平均， 单位:m-1
        a.setDieselVehicle_smoke1(new BigDecimal(1));//滤纸烟度1，单位:BSU
        a.setDieselVehicle_smoke2(new BigDecimal(1));//滤纸烟度2，单位:BSU
        a.setDieselVehicle_smoke3(new BigDecimal(1));//滤纸烟度3，单位:BSU
        a.setDieselVehicle_smokeBalance(new BigDecimal(1));//滤纸烟度平均， 单位:BSU
        a.setDieselVehicle_ratio100(new BigDecimal(1));//光吸收系数100%， 单位:m-1
        a.setDieselVehicle_ratio90(new BigDecimal(1));//光吸收系数90%， 单位:m-1
        a.setDieselVehicle_ratio80(new BigDecimal(1));//光吸收系数80%， 单位:m-1
        a.setDieselVehicle_maxWheelSideP(new BigDecimal(1));//实测最大轮边功率， 单位:kW
        a.setDieselVehicle_evaluate(new String("1"));// 判定，见附录B.8
        a.setSuspension_axleType(new String("1"));//轴类型，规定值:前轴、 后轴
        a.setSuspension_efficiencyOfLeftAxle(new BigDecimal(1));//左吸收率，单位:%
        a.setSuspension_efficiencyOfRightAxle(new BigDecimal(1));//右吸收率，单位:%
        a.setSuspension_absorbRateDifOfAxle(new BigDecimal(1));//左右差，单位:%
        a.setSuspension_evaluate(new String("1"));//判定，见附录B.8
        a.setMainLamp_axleType(new String("1"));//灯类型，见附录B.9
        a.setMainLamp_nearLightLamp(new BigDecimal(1));//灯高(近光)， 单位:mm
        a.setMainLamp_farLightLampHight(new BigDecimal(1));//灯高(远光)， 单位:mm
        a.setMainLamp_farLightStrong(new BigDecimal(1));//远光光强，单位:cd
        a.setMainLamp_farLightVOffset(new BigDecimal(1));//远光偏移(垂直)， 单位:H
        a.setMainLamp_farLightHOffset(new BigDecimal(1));//远光偏移(水平)， 单位:mm/10m
        a.setMainLamp_nearLightVOffset(new BigDecimal(1));//近光偏移(垂直)， 单位:H
        a.setMainLamp_nearLightHOffset(new BigDecimal(1));//近光偏移(水平)， 单位:mm/10m
        a.setMainLamp_evaluate(new String("1"));//判定，见附录B.8
        a.setSingleItem_itemCode(new String("1"));//单项检测项目编码,见 附录B.10
        a.setImage_imageUrl(new String("1"));//图片链接地址
        a.setImage_imageType(new String("1"));//检验工位照片类型,见 附录B.11
        a.setVideo_videoUrl(new String("1"));//图片链接地址
        a.setVideo_videoType(new String("1"));//检验工位照片类型,见 附录B.11
        a.setDetectReport_detectResult(new String("1"));//检验结论:一级、二级、 三级或合格、不合格
        a.setDetectReport_note(new String("1"));//备注
        a.setTractorInfo_vehicleNo(new String("1"));// 号牌号码
        a.setTractorInfo_vinNo(new String("1"));// 车辆识别代码
        a.setTractorInfo_engineNo(new String("1"));// 发动机号码
        a.setTractorInfo_client(new String("1"));// 委托人
        a.setTractorInfo_vehicleBrandModel(new String("1"));// 厂牌型号，参照JT/T 697.7
        a.setTractorInfo_administrativeAera(new String("1"));// 行政区划代码，参照 GB/T 2260
        a.setTractorInfo_vehicleType(new String("1"));// 车辆类型:参照GA 24.4
        a.setTractorInfo_transCertificateCode(new String("1"));// 道路运输证号
        a.setTractorInfo_registDate(new String("1"));// 注册登记日期，车辆行 驶证初领日期: YYYYMMDD
        a.setTractorInfo_productionDate(new String("1"));// 出厂年月: YYYYMMDD
        a.setTractorInfo_driveLicense(new String("1"));// 机动车行驶证号
        a.setTractorInfo_vehicleBodyColor(new String("1"));// 车身颜色,见附录B.2
        a.setTrailerInfo_vehicleNo(new String("1"));//号牌号码
        a.setTrailerInfo_client(new String("1"));//委托人
        a.setTrailerInfo_vehicleType(new String("1"));//车辆类型:参照GA 24.4
        a.setTrailerInfo_vehicleBrandModel(new String("1"));//厂牌型号，参照JT/T 697.7
        a.setTrailerInfo_transCertificateCode(new String("1"));//道路运输证号
        a.setTrailerInfo_registDate(new String("1"));//注册登记日期: YYYYMMDD
        a.setTrailerInfo_productionDate(new String("1"));//出厂日期: YYYYMMDD
        a.setTrailerInfo_vinNo(new String("1"));//车辆识别代码
        a.setTrailerInfo_driveLicense(new String("1"));//车辆行驶证号
        a.setManualTestResult_detectCls(new String("1"));//人工检验项目代码，见 附录B.13
        a.setManualTestResult_evaluate(new String("1"));//判定:见附录B.8
        a.setManualTestResult_unqualifiedItem(new String("1"));//不符合项目
        a.setPerformanceItem_itemCode(new String("1")) ;//性能检测项目编码，见 附B.14
        a.setPerformanceItem_detectData(new String("1")) ;//检测数据，各项格式参 照GB 18565
        a.setPerformanceItem_standardValue(new String("1")) ;//标准限值，各项格式参 照GB 18565
        a.setPerformanceItem_evaluate(new String("1")) ;//判定:见附录B.8

        String string = JSON.toJSONString(a);
        System.out.println("string = " + string);
        //{"brakeSeqTime_axle1":1,"brakeSeqTime_axle2":1,"brakeSeqTime_axle3":1,"brakeSeqTime_axle4":1,"brakeSeqTime_axle5":1,"brakeSeqTime_axle6":1,"brakeSeqTime_evaluate":"1","brakeSeq_axle1":"1","brakeSeq_axle2":"1","brakeSeq_axle3":"1","brakeSeq_axle4":"1","brakeSeq_axle5":"1","brakeSeq_axle6":"1","brakeSeq_evaluate":"1","busTypeLevel":"1","busiType":"1","carriageSsideboardHeight":1,"client":"1","compressIgnitEnginePower":1,"detectDate":"1","detectLine":"1","detectReport_detectResult":"1","detectReport_note":"1","detectSn":"1","detectTotalCount":1,"detectType":"1","dieselVehicle_evaluate":"1","dieselVehicle_maxWheelSideP":1,"dieselVehicle_ratio1":1,"dieselVehicle_ratio100":1,"dieselVehicle_ratio2":1,"dieselVehicle_ratio3":1,"dieselVehicle_ratio80":1,"dieselVehicle_ratio90":1,"dieselVehicle_ratioBalance":1,"dieselVehicle_smoke1":1,"dieselVehicle_smoke2":1,"dieselVehicle_smoke3":1,"dieselVehicle_smokeBalance":1,"driveAxleAmount":1,"driveAxleLoadMass":1,"driveBrake_brakeCoordinateTime":1,"driveBrake_brakeDistance":1,"driveBrake_brakeStability":"1","driveBrake_evaluate":"1","driveBrake_initialVelocity":1,"driveBrake_laneWidth":1,"driveBrake_mfdd":1,"driveType":"1","driveWheelModel":1,"dsId":"1","dsName":"1","engineNo":"1","farLightCanAdjust":"1","frontTrack":1,"fuelEconomy_evaluate":"1","fuelEconomy_measuredValue":1,"fuelEconomy_speedFuelPerHundredKm":1,"fuelType":"1","gasolineVehicle_co2540":1,"gasolineVehicle_co5025":1,"gasolineVehicle_evaluate":"1","gasolineVehicle_hc2540":1,"gasolineVehicle_hc5025":1,"gasolineVehicle_highCo":1,"gasolineVehicle_highHc":1,"gasolineVehicle_highL":1,"gasolineVehicle_lowCo":1,"gasolineVehicle_lowHc":1,"gasolineVehicle_no2540":1,"gasolineVehicle_no5025":1,"gasolineVehicle_vmasCo":1,"gasolineVehicle_vmasHc":1,"gasolineVehicle_vmasHcNo":1,"gasolineVehicle_vmasNo":1,"image_imageType":"1","image_imageUrl":"1","initData_axleLoadOfCompoundTable":1,"initData_axleSerialNo":1,"initData_leftDriveBrakeForce":1,"initData_leftDynamicWheelLoad":1,"initData_leftHorizontalLoadWheel":1,"initData_leftParkBrakeForce":1,"initData_rightDriveBrakeForce":1,"initData_rightDynamicWheelLoad":1,"initData_rightHorizontalLoadWheel":1,"initData_rightParkBrakeForce":1,"lampSystem":"1","mainLamp_axleType":"1","mainLamp_evaluate":"1","mainLamp_farLightHOffset":1,"mainLamp_farLightLampHight":1,"mainLamp_farLightStrong":1,"mainLamp_farLightVOffset":1,"mainLamp_nearLightHOffset":1,"mainLamp_nearLightLamp":1,"mainLamp_nearLightVOffset":1,"mainVehicleAxleAmount":1,"manualTestResult_detectCls":"1","manualTestResult_evaluate":"1","manualTestResult_unqualifiedItem":"1","overallSize":"1","overallSizeTrailer":"1","parkAxle":"1","parkBrake_evaluate":"1","parkBrake_parkResult":"1","parkBrake_parkSlope":1,"performanceItem_detectData":"1","performanceItem_evaluate":"1","performanceItem_itemCode":"1","performanceItem_standardValue":"1","plateColorCode":"1","power_evaluate":1,"power_loadingForce":1,"power_ratedSpeed":1,"power_standardPower":1,"power_steadySpeed":1,"productionDate":"1","ratedSpeedOfIgnit":1,"ratedTorque":1,"registDate":"1","seatCount":1,"shaftForm":"1","singleAxle_axleBrakeRate":1,"singleAxle_axleSerialNo":1,"singleAxle_brakeUnbalanceRate":1,"singleAxle_evaluate":"1","singleAxle_leftMaxProcessDiff":1,"singleAxle_leftRetardingForce":1,"singleAxle_rightMaxProcessDiff":1,"singleAxle_rightRetardingForce":1,"singleItem_itemCode":"1","singleVehicle_evaluate":"1","singleVehicle_horizontalWeight":1,"singleVehicle_parkBrakeRate":1,"singleVehicle_wholeVehicleBrakeRate":1,"ssideboardHeightTrailer":1,"steeringAxleAmount":1,"suspension_absorbRateDifOfAxle":1,"suspension_axleType":"1","suspension_efficiencyOfLeftAxle":1,"suspension_efficiencyOfRightAxle":1,"suspension_evaluate":"1","totalWeight":1,"totalWeightOfTractor":1,"tractorInfo_administrativeAera":"1","tractorInfo_client":"1","tractorInfo_driveLicense":"1","tractorInfo_engineNo":"1","tractorInfo_productionDate":"1","tractorInfo_registDate":"1","tractorInfo_transCertificateCode":"1","tractorInfo_vehicleBodyColor":"1","tractorInfo_vehicleBrandModel":"1","tractorInfo_vehicleNo":"1","tractorInfo_vehicleType":"1","tractorInfo_vinNo":"1","trailerInfo_client":"1","trailerInfo_driveLicense":"1","trailerInfo_productionDate":"1","trailerInfo_registDate":"1","trailerInfo_transCertificateCode":"1","trailerInfo_vehicleBrandModel":"1","trailerInfo_vehicleNo":"1","trailerInfo_vehicleType":"1","trailerInfo_vinNo":"1","trailerVehicleAxleAmount":1,"trailerVehicleNo":"1","trailerVehicleType":"1","transCertificateCode":"1","travelMileage":1,"truckBodyType":"1","vehicleBodyColor":"1","vehicleBrandModel":"1","vehicleHeight":1,"vehicleLength":1,"vehicleNo":"1","vehicleSerial1_brakeCoordinateTime":1,"vehicleSerial1_evaluate":"1","vehicleSerial1_horizontalWeight":1,"vehicleSerial1_parkBrakeRate":1,"vehicleSerial1_vehicleBrakeRateTractor":1,"vehicleSerial1_vehicleBrakeRateTrailer":1,"vehicleSerial2_brakeRateTractorTrain":1,"vehicleSerial2_brakeRateTrailerTrain":1,"vehicleSerial2_evaluate":"1","vehicleSuspensionForm":"1","vehicleType":"1","video_videoType":"1","video_videoUrl":"1","vinNo":"1"}
    }



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


    //power
    BigDecimal power_standardPower;//达标功率，单位:kW
    BigDecimal power_ratedSpeed;//额定车速，单位:km/h
    BigDecimal power_loadingForce;//加载力，单位:N
    BigDecimal power_steadySpeed;//稳定车速，单位:km/h
    BigDecimal power_evaluate;//判定:见附录B.8

//    FuelEconomy
    BigDecimal fuelEconomy_speedFuelPerHundredKm;//等速百公里油耗标准 限值
    BigDecimal fuelEconomy_measuredValue;//实测值
    String fuelEconomy_evaluate;//判定:见附录B.8

    BigDecimal initData_axleSerialNo;// 轴序号(第几轴)， 规定 值:1、2、3、4、5、6
    BigDecimal initData_leftHorizontalLoadWheel;// 水平称重轮荷(左轮)，单位: daN
    BigDecimal initData_rightHorizontalLoadWheel;// 水平称重轮荷(右轮)，单位: daN
    BigDecimal initData_axleLoadOfCompoundTable;// 复合台称重轴荷，单位: daN
    BigDecimal initData_leftDynamicWheelLoad;// 动态轮荷(左轮)，单位: daN
    BigDecimal initData_rightDynamicWheelLoad;// 动态轮荷(右轮)，单位: daN
    BigDecimal initData_leftDriveBrakeForce;// 行车制动力(左轮)，单位:daN
    BigDecimal initData_rightDriveBrakeForce;// 行车制动力(右轮)， 单位:daN
    BigDecimal initData_leftParkBrakeForce;//驻车制动力(左轮)， 单位:daN
    BigDecimal initData_rightParkBrakeForce;// 驻车制动力(右轮)， 单位:daN


    BigDecimal singleVehicle_horizontalWeight;// 水平称重，单位:daN
    BigDecimal singleVehicle_wholeVehicleBrakeRate;// 整车制动率，单位:%
    BigDecimal singleVehicle_parkBrakeRate;//驻车制动率，单位:%
    String singleVehicle_evaluate;// 判定:见附录B.8


    BigDecimal vehicleSerial1_horizontalWeight;// 水平称重，单位:daN
    BigDecimal vehicleSerial1_vehicleBrakeRateTractor;// 整车制动率(牵)， 单位:%
    BigDecimal vehicleSerial1_vehicleBrakeRateTrailer;// 整车制动率(挂)， 单位:%
    BigDecimal vehicleSerial1_parkBrakeRate;// 驻车制动率，单位:%
    BigDecimal vehicleSerial1_brakeCoordinateTime;// 制动协调时间，单位: s
    String vehicleSerial1_evaluate;// 判定:见附录B.8


    BigDecimal brakeSeqTime_axle1;//轴1，单位:s
    BigDecimal brakeSeqTime_axle2;//轴1，单位:s
    BigDecimal brakeSeqTime_axle3;//轴1，单位:s
    BigDecimal brakeSeqTime_axle4;//轴1，单位:s
    BigDecimal brakeSeqTime_axle5;//轴1，单位:s
    BigDecimal brakeSeqTime_axle6;//轴1，单位:s
    String brakeSeqTime_evaluate;// 判定:见附录B.8


    String brakeSeq_axle1;//轴1，规定值:1、2、3、 4、5、6
    String brakeSeq_axle2;//轴1，规定值:1、2、3、 4、5、6
    String brakeSeq_axle3;//轴1，规定值:1、2、3、 4、5、6
    String brakeSeq_axle4;//轴1，规定值:1、2、3、 4、5、6
    String brakeSeq_axle5;//轴1，规定值:1、2、3、 4、5、6
    String brakeSeq_axle6;//轴1，规定值:1、2、3、 4、5、6
    String brakeSeq_evaluate;// 判定:见附录B.8


    BigDecimal vehicleSerial2_brakeRateTractorTrain;//整车制动率比 %(牵引 车/列车)，单位:%
    BigDecimal vehicleSerial2_brakeRateTrailerTrain;//整车制动率比 %(挂车 /列车)，单位:%
    String vehicleSerial2_evaluate;// 判定:见附录B.8


    BigDecimal singleAxle_axleSerialNo; //轴序号(第几轴)，规定 值:1、2、3、4、5、6
    BigDecimal singleAxle_axleBrakeRate; //轴制动率，单位:%
    BigDecimal singleAxle_brakeUnbalanceRate;//制动不平衡率， 单位:%
    BigDecimal singleAxle_leftMaxProcessDiff;//过程差最大点(左轮)， 单位:daN
    BigDecimal singleAxle_rightMaxProcessDiff;// 过程差最大点(右轮)， 单位:daN
    BigDecimal singleAxle_leftRetardingForce;//车轮阻滞率(左轮)， 单位:%
    BigDecimal singleAxle_rightRetardingForce;// 车轮阻滞率(右轮)， 单位:%
    String singleAxle_evaluate;//判定，见附录B.8


    BigDecimal  driveBrake_initialVelocity;// 初速度，单位:km/h
    BigDecimal  driveBrake_laneWidth;// 试车道宽度，单位:m
    BigDecimal  driveBrake_brakeDistance;// 制动距离，单位:m
    BigDecimal  driveBrake_mfdd;// MFDD，单位:m/s2
    String      driveBrake_brakeStability;// 制动稳定性，规定值: 稳定、不稳定
    BigDecimal  driveBrake_brakeCoordinateTime;// 汽车列车制动协调时 间，单位:s
    String      driveBrake_evaluate;// 判定，见附录B.8


    BigDecimal parkBrake_parkSlope;// 驻车坡度，单位:%
    String parkBrake_parkResult;// 不少于5 min坡道驻车 情况，规定值:溜坡、 不溜坡
    String parkBrake_evaluate;// 判定，见附录B.8


    BigDecimal gasolineVehicle_highCo;//CO_高怠速，单位:%
    BigDecimal gasolineVehicle_highHc;//HC_高怠速，单位:10-6
    BigDecimal gasolineVehicle_highL;//λ_高怠速
    BigDecimal gasolineVehicle_lowCo;//CO_怠速，单位:%
    BigDecimal gasolineVehicle_lowHc;//HC_怠速，单位:10-6
    BigDecimal gasolineVehicle_co5025;//CO_5025，单位:%
    BigDecimal gasolineVehicle_hc5025;//HC_5025，单位:10-6
    BigDecimal gasolineVehicle_no5025;//NO_5025，单位:10-6
    BigDecimal gasolineVehicle_co2540;//CO_2540，单位:%
    BigDecimal gasolineVehicle_hc2540;//HC_2540，单位:10-6
    BigDecimal gasolineVehicle_no2540;//NO_2540，单位:10-6
    BigDecimal gasolineVehicle_vmasCo;//CO_简易瞬态工况， 单位:g/km
    BigDecimal gasolineVehicle_vmasHc;//HC_简易瞬态工况， 单位:g/km
    BigDecimal gasolineVehicle_vmasNo;//NO_简易瞬态工况， 单位:g/km
    BigDecimal gasolineVehicle_vmasHcNo;//HC_NO_简易瞬态工况， 单位:g/km
    String gasolineVehicle_evaluate;// 判定，见附录B.8


    BigDecimal dieselVehicle_ratio1;//光吸收系数1， 单位:m-1
    BigDecimal dieselVehicle_ratio2;//光吸收系数1， 单位:m-1
    BigDecimal dieselVehicle_ratio3;//光吸收系数1， 单位:m-1
    BigDecimal dieselVehicle_ratioBalance;//光吸收系数平均， 单位:m-1
    BigDecimal dieselVehicle_smoke1;//滤纸烟度1，单位:BSU
    BigDecimal dieselVehicle_smoke2;//滤纸烟度2，单位:BSU
    BigDecimal dieselVehicle_smoke3;//滤纸烟度3，单位:BSU
    BigDecimal dieselVehicle_smokeBalance;//滤纸烟度平均， 单位:BSU
    BigDecimal dieselVehicle_ratio100;//光吸收系数100%， 单位:m-1
    BigDecimal dieselVehicle_ratio90;//光吸收系数90%， 单位:m-1
    BigDecimal dieselVehicle_ratio80;//光吸收系数80%， 单位:m-1
    BigDecimal dieselVehicle_maxWheelSideP;//实测最大轮边功率， 单位:kW
    String dieselVehicle_evaluate;// 判定，见附录B.8


    String suspension_axleType;//轴类型，规定值:前轴、 后轴
    BigDecimal suspension_efficiencyOfLeftAxle;//左吸收率，单位:%
    BigDecimal suspension_efficiencyOfRightAxle;//右吸收率，单位:%
    BigDecimal suspension_absorbRateDifOfAxle;//左右差，单位:%
    String suspension_evaluate;//判定，见附录B.8


    String mainLamp_axleType;//灯类型，见附录B.9
    BigDecimal mainLamp_nearLightLamp;//灯高(近光)， 单位:mm
    BigDecimal mainLamp_farLightLampHight;//灯高(远光)， 单位:mm
    BigDecimal mainLamp_farLightStrong;//远光光强，单位:cd
    BigDecimal mainLamp_farLightVOffset;//远光偏移(垂直)， 单位:H
    BigDecimal mainLamp_farLightHOffset;//远光偏移(水平)， 单位:mm/10m
    BigDecimal mainLamp_nearLightVOffset;//近光偏移(垂直)， 单位:H
    BigDecimal mainLamp_nearLightHOffset;//近光偏移(水平)， 单位:mm/10m
    String mainLamp_evaluate;//判定，见附录B.8


    String singleItem_itemCode;//单项检测项目编码,见 附录B.10


    String image_imageUrl;//图片链接地址
    String image_imageType;//检验工位照片类型,见 附录B.11


    String video_videoUrl;//图片链接地址
    String video_videoType;//检验工位照片类型,见 附录B.11


    String detectReport_detectResult;//检验结论:一级、二级、 三级或合格、不合格
    String detectReport_note;//备注


    String tractorInfo_vehicleNo;// 号牌号码
    String tractorInfo_vinNo;// 车辆识别代码
    String tractorInfo_engineNo;// 发动机号码
    String tractorInfo_client;// 委托人
    String tractorInfo_vehicleBrandModel;// 厂牌型号，参照JT/T 697.7
    String tractorInfo_administrativeAera;// 行政区划代码，参照 GB/T 2260
    String tractorInfo_vehicleType;// 车辆类型:参照GA 24.4
    String tractorInfo_transCertificateCode;// 道路运输证号
    String tractorInfo_registDate;// 注册登记日期，车辆行 驶证初领日期: YYYYMMDD
    String tractorInfo_productionDate;// 出厂年月: YYYYMMDD
    String tractorInfo_driveLicense;// 机动车行驶证号
    String tractorInfo_vehicleBodyColor;// 车身颜色,见附录B.2


    String trailerInfo_vehicleNo;//号牌号码
    String trailerInfo_client;//委托人
    String trailerInfo_vehicleType;//车辆类型:参照GA 24.4
    String trailerInfo_vehicleBrandModel;//厂牌型号，参照JT/T 697.7
    String trailerInfo_transCertificateCode;//道路运输证号
    String trailerInfo_registDate;//注册登记日期: YYYYMMDD
    String trailerInfo_productionDate;//出厂日期: YYYYMMDD
    String trailerInfo_vinNo;//车辆识别代码
    String trailerInfo_driveLicense;//车辆行驶证号


    String manualTestResult_detectCls;//人工检验项目代码，见 附录B.13
    String manualTestResult_evaluate;//判定:见附录B.8
    String manualTestResult_unqualifiedItem;//不符合项目

    String performanceItem_itemCode ;//性能检测项目编码，见 附B.14
    String performanceItem_detectData ;//检测数据，各项格式参 照GB 18565
    String performanceItem_standardValue ;//标准限值，各项格式参 照GB 18565
    String performanceItem_evaluate ;//判定:见附录B.8


}
