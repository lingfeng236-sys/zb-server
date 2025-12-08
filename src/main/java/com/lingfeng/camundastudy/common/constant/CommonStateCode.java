package com.lingfeng.camundastudy.common.constant;

/**
 * comment:
 * author: zhuozhijin
 * date: 2022/1/5 3:37 PM
 */
public enum CommonStateCode {
    //系统相关功能 3000-4500
    SUCCESS(200, "成功", "Success"),

    UNAUTHORIZED(401, "未登录或登录信息已过期,请重新登录","Not logged in or login expired, please try log in again"),
    FORBIDDEN(403, "没有权限","No permission"),
    ERROR(500, "服务端错误","Server error"),
    LACK_SETTING(501,"服务端错误(缺少基本配置)","Server error (missing basic configuration)"),
    EXIST_ILLEGAL_DATA(502,"服务端存在非法数据","Server error (exist illegal data)"),
    ACQUIRE_SYSTEM_RESOURCE_FAIL(503,"服务端错误(获取系统资源失败)","Server error (acquire system resource failed)"),
    THERE_ARE_MANDATORY_FIELDS_THAT_HAVE_NOT_BEEN_FILLED_IN(1001,"存在必填字段未填","Mandatory fields are missing"),
    VALUE_NOT_NULL(1002,"值[#{param}]不能为空","Value [#{param}] can not null"),
    VALUE_ALREADY_EXISTS(1003,"值[#{param}]已存在","Value [#{param}] already exists"),
    VALUE_NOT_EXISTS(1004,"值[#{param}]不存在","Value [#{param}] not exists"),
    DATA_ALREADY_EXISTS(3001,"数据已存在","Data already exists"),
    BUSINESS_CODE_IS_NOT_EXIST(3002,"businessCode不存在","Original item code does not exist"),
    DATA_NOT_EXISTS(3003,"数据不存在","Data does not exist"),
    DATA_FORBIDDEN(4000, "没有数据权限","No Data Permission"),
    ILLEGAL_PARAMETER(4001, "非法参数","Illegal parameter"),
    LACK_PARAMETER(4002,"缺少参数","Missing parameter"),
    URL_TRANSFORMATION_FAILED(4003,"url转换失败，格式错误","url transformation failed, format error"),
    BUSINESS_TASK_DATA_IS_EMPTY(4004,"任务数据为空","Task data is empty"),
    LACK_LOCK_KEY_PARAMETER(4005,"缺少关键锁参数","Missing Lock Key Parameter"),
    ERROR_PARAM(500, "服务端错误:[#{param}]","Server error"),
    /**
     * OSS文件路径解析失败
     */
    OSS_FILE_PATH_PARSE_FAILED(5000,"OSS文件路径解析失败","OSS file path parsing failed"),



    //文件导入导出
    FILES_EXCEED_THE_MAXIMUM_LIMIT(2000,"文件超过最大数量限制10000","File exceeds the maximum limit of 10000"),
    BE_IMPORTING(2001, "导入中","Importing"),
    IMPORT_FAIL(2002, "导入失败","Import failed"),
    UPDATE_FAIL(2003,"更新失败","Update failed"),

    //用户角色权限等后台相关
    WRONG_PASSWORD(4003,"用户名或者错误","Incorrect username or password"),
    SEND_DING_NOTIFY_ERROR(4004, "发送钉钉通知出现错误"),
    DING_QUERY_ERROR(4005, "钉钉查询接口调用出现错误"),
    DING_LOGIN_ERROR(4006, "钉钉登录接口调用出现错误"),
    DING_USER_ID_ERROR(4007, "钉钉用户不存在"),
    USER_EXIT_ERROR(4008, "当前用户已经存在"),
    ROLE_NOT_EXIST(4009, "角色不存在"),
    ILLEGAL_PASSWORD(4010, "至少包含：大写字母+小写字母+数字[不少于8个字符]"),
    NOTICE_RULE_NOT_CONFIGURED(4011,"通知规则未配置"),
    USER_EMAIL_NOT_EXIT(4012,"当前用户邮箱不存在"),
    USER_EMAIL_FORMAT_ERROR(4013,"当前用户邮箱格式错误"),
    FILE_UPLOAD_EXCEPTION(4014,"文件上传异常"),
    ACQUIRE_TEMPORARY_TOKEN_ERROR(4015,"获取临时令牌错误"),
    THE_ACCOUNT_HAS_BEEN_DISABLED(4016,"该帐户已被禁用,请联系管理员"),
    PUBLISH_ERP_DATA_DICTIONARY_AS_EMPTY(4017,"发布ERP数据字典为空"),
    UNIQUENESS_VERIFICATION_FAILED(4018,"唯一性校验失败,与单号[#{param}]重复"),
    NOT_RIGHT_NUMBER(4019, "请输入有效的数值（大于零）,"),
    EXCEL_DATA_ERROR(4020, "Excel Data Verification Failed"),
    EXCEL_TEMPLATE_ERROR(4021, "Excel 模板解析失败，请检查数据模板以及数据填写是否正确"),
    BATCH_SAVE_ERROR(4023,"批量新增异常"),
    CANT_OPERATE_DATA(4024,"当前用户没有权限处理其他人的任务","The current user does not have permission to operate on other people's task"),
    EXPORT_RESULTS_ARE_BEING_PROCESSED(4025,"导出结果正在被处理，请稍后再下载"),
    TRIGGER_CONDITION_CANNOT_BE_EMPTY(4026,"钉钉通知触发条件不能为空"),
    THE_TRIGGER_CONDITION_CONTAINS_EMPTY_FIELDS(4027,"钉钉通知触发条件包含的字段为空"),
    EXCEL_PARSING_FAILED_OR_DATA_IS_EMPTY(4028,"EXCEL解析失败或EXCEL中没有数据"),
    THERE_ARE_UNDELETED_DICTIONARIES_PRESENT(4029,"存在未删除的字典项"),
    USER_NOT_ASSIGN_MENU(4030,"未分配菜单"),
    ACCOUNT_BE_OCCUPIED(4031, "帐号已经被多个邮箱占用,请联系管理员查验"),
    MUL_SAME_EMAIL_ERROR(4032, "邮箱已经被多次注册使用,请联系管理员查验"),
    RE_TRY_EXPORT_RESULTS(4033,"导出数据出小差～请重新尝试导出"),
    DOWNLOAD_RESULTS_ARE_BEING_PROCESSED(4034,"文件下载结果正在被处理，请稍后查看"),
    USER_NOT_EXIST_OR_DING_USER_ID_NOT_EXIST(4035, "当前用户不存在或当前用户不存在钉钉用户ID"),

    //下载文件任务 4500-4600
    DOWNLOAD_FILE_TASK_ALREADY_EXISTS(4500,"请不要频繁提交疑似相同的下载文件任务"),
    DOWNLOAD_FILE_TASK_HANDLER_NOT_EXISTS(4501,"下载任务处理器不存在,请联系开发完善"),
    DOWNLOAD_FILE_TASK_RECORD_NOT_EXISTS(4502,"下载任务记录不存在"),
    DOWNLOAD_FILE_TASK_STATUS_IS_NOT_FAILURE(4503,"无法重新触发下载任务,下载任务记录状态必须是失败状态才可以重新触发"),
    DOWNLOAD_FILE_TASK_INTERRUPTED(4504,"任务被中断"),
    ZIP_FILE_IS_EMPTY(4505,"压缩列表为空"),
    GENERATE_COMPRESSED_PACKAGE_FAILED(4506,"生成压缩包失败"),

    //物料  5000-5499
    DATA_STATUS_ERROR(5000,"没有符合规范的发布数据状态"),
    FEED_ORDER_MUST_ALL_FILLED_OR_BLANK(5001," 投料顺序必须均有值或者均为空"),
    FEED_ORDER_NOT_REPEAT_NUMBER(5002,"投料顺序不可重复数字"),
    CHANGE_FEED_ORDER_MUST_ALL_FIELD(5003,"变更前有投料顺序则投料顺序必须有值"),
    GENERATE_SOLID_MATERIAL_FAIL(5004,"生成实物料失败"),
    MATERIAL_NOT_EXIST(5005,"物料不存在"),
    MATERIAL_CATEGORY_IS_NULL(5006,"物料分类不存在"),
    THE_ATTRIBUTE_VALUES_OF_THE_MATERIAL_ARE_INCOMPLETE(5007,"物料的属性值不完整，请补充"),
    THE_CURRENT_CLASSIFICATION_HAS_BEEN_ENABLED_AND_DELETION_IS_NOT_ALLOWED(5008,"当前分类已被启用，不允许删除"),
    THE_CURRENT_CLASSIFICATION_SUBCLASS_IS_NOT_EMPTY(5009,"当前分类子类存在物料，不能删除"),
    THERE_ARE_MATERIALS_IN_THE_CURRENT_CLASSIFICATION_SUBCLASS(5010,"当前分类子类存在物料，不能删除"),
    THE_MATERIAL_HAS_BEEN_FROZEN(5011,"物料已被冻结"),
    MATERIALS_UNDER_REVIEW(5012,"物料正在审核"),
    THE_MATERIAL_IS_BEING_REVIEWED_AND_HAS_BECOME_EFFECTIVE(5013,"物料已生效[正式]，变更请提交变更申请"),
    THE_MATERIAL_HAS_BECOME_EFFECTIVE_AND_CANNOT_BE_DELETED(5014,"物料已生效，不可删除"),
    FAILED_TO_ADD_LABEL_MATERIAL(5015,"新增标签物料失败"),
    THE_NAMES_OF_MAJOR_MEDIUM_AND_MINOR_CATEGORIES_OF_MATERIALS_CANNOT_BE_EMPTY(5016,"物料大类、中类、小类名称不能为空！"),
    MATERIAL_NOT_RELEASED_TO_ERP(5017,"物料还未发布ERP"),
    THE_MATERIAL_BUSINESS_STATUS_HAS_NOT_CHANGED(5018,"物料业务状态未发生变更，请检查参数是否正确"),
    FAILED_TO_SYNCHRONIZE_ERP_STATUS(5019,"同步ERP状态失败"),
    FAILED_TO_SAVE_MATERIAL(5020,"保存物料失败!"),
    THE_MATERIAL_CODE_AND_VERSION_ALREADY_EXIST(5021,"物料编码和版本已经存在！"),
    CLASSIFICATION_DOES_NOT_MAINTAIN_MATERIAL_PROPERTIES(5022,"保存失败，未维护物料属性的物料分类不允许启用"),
    THE_MATERIAL_CLASSIFICATION_REFERENCED_BY_THE_MATERIAL_CANNOT_BE_DEACTIVATED(5023,"保存失败，已被物料引用的物料分类不允许停用"),
    THE_SORTING_OF_MATERIAL_ATTRIBUTE_SPLICING_NAMES_CANNOT_BE_EMPTY(5024,"物料属性拼接名称排序不能为空"),
    UNKNOWN_MATERIAL_CLASSIFICATION(5025,"未知的物料分类"),
    THE_CURRENT_CLASSIFICATION_DOES_NOT_BELONG_TO_THE_MATERIAL_CLASSIFICATION(5026,"当前分类不属于物料分类"),
    THE_MATERIAL_ATTRIBUTE_CONFIGURATION_IS_EMPTY(5027,"物料属性配置为空，请先到指定物料分类下配置其属性与命名规则"),
    THE_PUBLISHED_MATERIAL_IS_EMPTY(5028,"发布物料为空"),
    MATERIAL_DATA_VALIDATION_FAILED_WITH_EMPTY_ATTRIBUTES(5029,"[#{param}]为必填属性，不能为空"),
    DATA_DICTIONARY_VALIDATION_FAILED_THERE_IS_AN_UNKNOWN_DICTIONARY_VALUE_PRESENT(5030,"[#{param}]数据字典验证失败：存在未知的字典值"),
    FAILED_TO_OBTAIN_MATERIAL_NAME(5031,"物料名称获取失败：请检查物料分类下其属性与命名规则配置是否正确"),
    THERE_ARE_IDENTICAL_MATERIAL_ATTRIBUTE_VALUES_AND_MATERIAL_CODES(5032,"存在完全相同的物料属性值与物料编码：[#{param}]"),
    UNKNOWN_MATERIAL_TYPE_PRIMARY_KEY(5033,"数据异常：未知的物料类型主键"),
    INVALID_SUPERIOR_CLASSIFICATION(5034,"新增物料分类失败，无效的上级分类"),
    PUBLISHING_ERP_MATERIAL_CLASSIFICATION_CANNOT_BE_EMPTY(5035,"发布ERP物料分类不能为空"),
    FAILED_TO_OBTAIN_CLASSIFICATION_BASED_ON_CODE(5036,"根据code获取分类失败"),
    FAILED_TO_GENERATE_MATERIAL(5037,"生成物料失败"),
    THE_MATERIAL_CODE_CANNOT_BE_EMPTY(5038,"物料编码不能为空"),
    NO_MATERIAL_DATA_SELECTED(5039,"未选择物料数据"),
    MATERIAL_NAME_CANNOT_BE_EMPTY_REQUIRED_FIELDS_ARE_NOT_FILLED_IN(5040,"物料名称不能为空,必填项未填"),
    CHANGE_SKU_MATERIAL_NOT_EXIST(5041,"变更SKU-物料不存在"),
    MISSING_FACTORY_DEFAULT_CONTACT_EMAIL(5042,"缺失工厂默认联系人邮箱"),
    UNCONFIGURED_CONTACT_EMAIL(5043,"存在工厂未配置联系人邮箱"),
    EXIST_SMOKE_OIL_SUPPLIER_MODEL_MATERIAL(5044,"已存在相同烟油化学/供方型号的物料"),
    MATERIAL_EXIST_SKU_CHANGE_SKU(5045,"物料如果存在对应的SKU，只能通过变更SKU来更改物料属性"),
    INTERCEPT_LAST_STR(5045,"截取字符串长度不能超过原字符串长度"),
    BATCH_QUERY_NUM_NOT_EXCEED_500(5046,"批量查询数量最大不超过500"),
    RIGHT_TEMPLATE_DOWNLOAD_AGAIN(5047,"请下载并使用正确的导入模板"),
    MATERIAL_NOT_EXIST_WITH_DETAIL(5048,"物料不存在,物料id-物料code:#{valueMap}"),
    MATERIAL_MUST_EFFECTIVE(5049,"物料必须为正式"),
    MATERIAL_CHANGE_DATA_EXCEPTION(5050,"物料变更后升版数据存在异常"),
    MATERIAL_STATUS_EXCEPTION(5051,"物料状态异常"),
    MATERIAL_NOT_EXIST_CHANGE_DATA(5052,"物料变更不存在ecnChangeData数据"),
    MATERIAL_UPDATE_DATA_IS_NULL(5053,"物料变更数据为空"),
    //更新的物料编码在数据库中不存在
    UPDATE_MATERIAL_CODE_NOT_EXIST(5054,"更新的物料编码在数据库中不存在"),
    MATERIAL_CANNOT_SAME(5055,"替换物料与被替换物料不能一致"),
    BE_REPLACED_MATERIAL_NOT_EXIST(5056,"被替换物料不存在"),
    NOT_SUPPORT_CURRENT_CHANGE_TAG(5057,"不支持当前变更操作"),
    //物料已停用
    MATERIAL_DISABLED(5058,"物料小类已停用"),
    //物料编码不存在
    MATERIAL_CODE_PARAM_NOT_EXIST(5200,"物料编码[#{param}]不存在"),


    //物料分类 5200-5499
    MATERIAL_CATEGORY_SMALL_EXIST(5201," 物料小类：分类名称[#{param}]已存在"),
    MATERIAL_CATEGORY_SMALL_EXIST_AND_CODE_DIFF(5202," 物料小类：分类名称[#{param}]已存在，且分类编码与导入文件不一致"),
    MATERIAL_CATEGORY_MIDDLE_EXIST(5203," 物料中类：分类名称[#{param}]已存在"),
    MATERIAL_CATEGORY_MIDDLE_EXIST_AND_CODE_DIFF(5204," 物料中类：分类名称[#{param}]已存在，且分类编码与导入文件不一致"),
    MATERIAL_CATEGORY_BIG_EXIST(5205," 物料大类：分类名称[#{param}]已存在"),
    MATERIAL_CATEGORY_BIG_EXIST_AND_CODE_DIFF(5206," 物料大类：分类名称[#{param}]已存在，且分类编码与导入文件不一致"),
    MATERIAL_CATEGORY_CODE_NOT_EXIST(5207," 物料编码：编码[#{param}]，对应的物料分类不存在"),
    MATERIAL_CATEGORY_NOT_NULL(5208,"该节点物料分类不能为空"),

    //spu 5500-5999
    SPU_NOT_EXIST(5501,"SPU不存在"),
    CURRENT_SPU_STATUS_IS_MODIFYING(5502,"当前SPU正在变更"),
    CURRENT_SPU_STATUS_CAN_NOT_EFFECTIVE(5510,"当前SPU状态不可变更"),
    CURRENT_SPU_STATUS_IS_NOT_EFFECTIVE(5511,"当前SPU不是正式状态"),
    RELATE_SPU_STATUS_IS_NOT_EFFECTIVE(5512,"关联的SPU不是正式状态"),
    SPU_CATEGORY_CANNOT_BE_EMPTY(5514,"spu品类不能为空","SPU category cannot be empty"),
    SPU_STATUS_AND_VERSION_CANNOT_EDIT(5515,"SPU状态和版本不支持编辑"),
    SPU_NOT_FOUND_OR_NOT_MAINTAINED_BUNKER_NUM(5516, "找不到对应的spu或spu未维护对应油仓数量"),
    SPU_UNIQUENESS_VALIDATION_FAILED(5517, "初始品名已存在，唯一性校验失败"),
    SPU_CANNOT_BE_EMPTY(5518,"spu不能为空","SPU cannot be empty"),
    //SPU包装结构 5550-5599,
    SPU_PSR_DOES_NOT_EXIST(5550,"包装结构不存在","SPU Packaging Structure Requirements does not exist"),
    SPU_PSR_REPEAT(5551,"spu对应的包装结构存在多条","Multiple packaging structures exist for the SPU"),
    SPU_PSR_DO_NOT_GET_PSE(5552,"没有获取到包装结构工程师信息","Failed to retrieve packaging structure engineer information"),
    SPU_PSR_TASK_USER_ID_ERROR(5553,"SPU任务流配置人员id错误","SPU workflow configuration personnel ID is incorrect"),
    SPU_PSR_CREATE_ERROR(5553,"创建包装结构工程师错误","Error creating packaging structure engineer"),
    SPU_TASK_USER_INCOMPLETE(5554,"SPU任务成员存在未填项","SPU task member incomplete"),
    SPU_PROJECT_EXPERIENCE_REQUIRED(5555,"SPU项目成员项目经理必填","SPU project member Project Manager is required"),
    SPU_PRODUCT_DATA_MANAGEMENT_REQUIRED(5556,"SPU项目成员PDM必填","SPU project member PDM is required"),
    SPU_PRODUCT_MANAGER_REQUIRED(5557,"SPU项目成员产品经理必填","SPU project member Product Manager is required"),
    SPU_GTM_REQUIRED(5558,"SPU项目成员GTM必填","SPU project member GTM is required"),
    SPU_FINANCE_REQUIRED(5559,"SPU项目成员财务必填","SPU project member Finance is required"),
    PUBLISH_ERP_DATA_WITH_EMPTY_SPU(5560,"发布ERP数据Spu为空","Publish ERP data Spu is empty"),
    PENDING_IMPROVEMENT_PENDING_DESIGN_AND_PENDING_DESIGN_AFTER_REJECTION_CAN_EDITED(5561,"仅处于待完善、待设计、驳回后待设计状态可编辑","Only pending improvement, pending design, and pending design after rejection can be edited"),
    SPU_ALREADY_EXISTS(5562,"spu已存在","SPU already exists"),
    SPU_PSE_REQUIRED(5563,"包装结构工程师必填","Packaging Structure Engineer is required"),
    SPU_NAME_EXISTS_MULTIPLE_SPU(5564,"spu名称对应的spu存在多个","SPU name corresponds to multiple SPU"),
    PKG_GRADE_EXIST_ERROR(5565, "该包装等级已存在启用中的规则", "The package grade already exists in the enabled state"),
    SPU_PSE_STATUS_ERROR(5570, "当前状态不允许编辑", "The current state does not allow editing"),
    PACKAGE_COST_NOT_EXIST(5571,"包装成本数据不存在","Package cost data does not exist"),
    COUNTRY_PACKAGE_COST_NOT_EXIST(5572,"国家包装成本数据不存在","Country package cost data does not exist"),
    SPU_PSR_EXISTS(5573,"spu对应的包装结构已存在","SPU Packaging Structure already exists"),
    MATERIAL_TYPE_ERROR(5574,"物料类型填写有误","Material type is incorrect"),
    SPR_DESIGN_MATERIAL_CODE_CANNOT_BE_EMPTY(5575,"其他物料类型的物料编码不能为空","The material code of other material types cannot be empty"),
    SPU_PSR_DESIGN_EXISTS(5576,"spu对应的包装结构设计已存在","SPU Packaging Structure Design already exists"),
    SPU_RESERVE_COST_EXISTS(5577,"spu对应的储备成本已存在","SPU Reserve Cost already exists"),
    SPU_RESERVE_PSR_REQUIREMENT_NOT_EXIST(5578,"spu对应的包装结构需求不存在","SPU Packaging Structure Requirement does not exist"),
    PACKAGE_DESIGN_BASIC_SCHEME_EXISTS(5579,"包装设计对应的基准方案已存在","The basis scheme of the packaging design already exists"),
    PACKAGE_MATERIAL_TYPE_ERROR(5580,"请选择除小盒、中盒、外箱之外的包材物料","Please select the material type other than small box, medium box, and outer box"),
    PSR_PROJECT_NAME_IS_NULL(5581,"包装结构需求项目名为空"),
    PSR_PROJECT_NAME_EXISTS(5582,"包装结构需求项目名已存在"),
    PSR_CODE_IS_NULL(5583,"包装结构需求编码为空"),
    PSR_CANNOT_BE_RETRACTED(5584,"当前SPU包装结构需求的状态不支持撤回","Packaging Structure Requirements CANNOT BE RETRACTED"),
    PSR_CANNOT_BE_CLOSE(5584,"当前SPU包装结构需求的状态不支持撤回","Packaging Structure Requirements CANNOT BE CLOSE"),
    COUNTRY_PACKAGE_COST_STATUS_NOT_SUPPORT_RETRACT(5585,"国家包装成本状态不支持撤回","Country Packaging Cost Status Not Support Retract"),
    PSR_CANNOT_BE_DELETED(5586,"当前SPU包装结构需求的状态不支持删除","Packaging Structure Requirements CANNOT BE DELETED"),
    PSR_PROJECT_NAME_NOT_EXIST(5587,"包装结构需求项目名不存在"),

    //sku  6000-6499
    SKU_NOT_EXIST(6000,"SKU不存在"),
    CURRENT_SKU_STATUS_NOT_EFFECTIVE(6001,"当前SKU为正式状态"),
    SKU_APPLY_NOT_EXIST(60002,"新品申请单不存在"),
    ONLY_IN_A_PENDING_STATE_FOR_BATCH_EDITING(6013,"仅处于待完善状态可批量编辑"),
    FLAVOR_CLASSIFICATION_DOES_NOT_EXIST(6014,"口味分类不存在"),
    THE_ATOMIZATION_ROD_CANNOT_GENERATE_OIL_ADAPTATION_TASKS(6015,"雾化杆不能生成烟油适配任务"),
    THE_APPLICATION_FORM_MUST_BE_IN_THE_STATUS_OF_SUCCESSFUL_APPLICATION(6016,"该申请单必须为申请成功状态"),
    NO_DATA_SELECTED_BATCH_EDITING_FUNCTION_UNAVAILABLE(6017,"没有选择数据，批量编辑功能不可用"),
    CAN_ONLY_BE_DELETED_IN_DRAFT_AND_APPLICATION_REJECTION_STATUS(6018,"仅草稿、申请驳回状态下可删除"),
    THE_SKU_APPLICATION_FORM_IN_THIS_STATUS_IS_NOT_EDITABLE(6019,"该状态下的SKU申请单不可编辑"),
    FAILED_TO_OBTAIN_SPU_PKV_TABLE_BASED_ON_SPU_CODE_AND_SKU_APPLY_PACKAGING_VERSION(6020,"根据spuCode和新品申请包装版本获取SPU包装版本规则表失败"),
    THE_PKV_CMF_AND_SKU_APPLY_CATEGORY_OBTAIN_CMF_RULES_ARE_EMPTY(6021,"包装版本规则cmf版本和新品申请品类获取cmf规则为空"),
    THE_MATERIAL_CLASSIFICATION_OBTAINED_BASED_ON_THE_THREE_LEVEL_ID_IS_EMPTY(6022,"根据三级分类id获取物料分类信息为空"),
    THE_PACKAGING_VERSION_DOES_NOT_EXIST_IN_THE_PACKAGING_VERSION_RULE_TABLE(6023,"包装规格未配置"),
    THE_CURRENT_STATUS_DOES_NOT_SUPPORT_CLOSING(6026,"当前状态不支持关闭"),
    LIQUID_IS_NOT_READY(6027,"烟油适配未通过，无法完成审批", "Liquid is not ready, unable to proceed"),
    SPU_DATA_IS_NOT_READY(6028,"SPU数据尚未锁定，无法完成审批", "SPU data is not ready, unable to proceed"),
    ADD_ONE_FLAVOR_ONTOLOGY(6029,"请至少添加一个口味本体"),
    SKU_APPLY_NOT_DUPLICATE(6030,"口味本体中文名+实际尼古丁浓度不能重复"),
    CURRENT_SKU_APPLY_STATUS_NOT_EFFECTIVE(6031,"当前新品申请是申请成功状态"),
    PLEASE_SELECT_SEND_FACTORY(6032,"请选择发送工厂"),
    SELECT_FACTORY_CONTACT_IS_EMPTY(6033,"所选工厂的联系人为空"),
    //存在状态为非待完善状态的数据，请检查
    THERE_EXISTS_DATA_WITH_A_STATUS_OTHER_THAN_PENDING_IMPROVEMENT(6032,"存在状态为非待完善状态的数据，请检查", "There exists data with a status other than pending improvement, please check"),
    /**
     * 烟油适配需求不存在
     */
    LIQUID_REQUIREMENT_NOT_EXIST(6033,"烟油适配需求不存在"),
    BUNKER_FIELD_IS_REQUIRED(6034,"油仓字段必填"),
    HW_VERSION_IS_REQUIRED(6035,"软硬件版本必填"),
    TASK_NOT_OPENED_CANNOT_BE_CLOSED(6036,"当前数据未处在新品创建流程中，不支持关闭"),
    LIQUID_REQUIREMENT_OIL_TANK_NOT_EMPTY(6037,"油仓不能为空"),

    //skuBOM、FactoryBom  6500-6999
    CURRENT_SKU_BOM_STATUS_NOT_EFFECTIVE(6500, "当前 sku bom 状态不在生效状态"),
    CURRENT_SKU_BOM_STATUS_IS_MODIFYING(6501, "当前 sku bom 状态正在修改"),
    REMOVE_BOM_NEED_DRAFT_STATUS(6502, "只能删除草稿状态的bom"),
    INCOMPATIBLE_PAUSE_PRECONDITION(6503, "只能暂停正式状态和更改状态"),
    BOM_NOT_EXIST(6504,"Bom 不存在"),
    FACTORY_BOM_NOT_EXIST(6505,"工厂Bom不存在"),
    BEFORE_FACTORY_AUTHORIZATION(6506,"只能给正式的bom 进行授权工厂"),
    CANT_AUTHORIZE_SAME_FACTORY(6507,"不能授权同一家工厂,工厂为: [#{param}]"),
    ACQUIRE_BOM_CODE_TIMEOUT(6508,"获取bom code超时"),
    ACQUIRE_FACTORY_BOM_CODE_TIMEOUT(6509,"获取factory bom code超时"),
    ACQUIRE_INDEPENDENT_BOM_DETAIL_ID_TIMEOUT(6510,"获取bom detail 资源超时"),
    EXIST_UNCOMMITTED_FACTORY_BOM(6511,"当前bom存在未提交的工厂bom,请先提交未提交的工厂bom"),
    CANT_COPY_CURRENT_BOM(6512,"只能复制标准Bom"),
    NEED_ONE_VIRTUAL_MATERIAL_BOM(6514,"至少需要一个虚物料"),
    CURRENT_SPU_BOM_STATUS_NOT_EFFECTIVE(6518, "前置SPU BOM流程尚未结束，请联系【学忠】或【张玲】处理"),
    VIRTUAL_BOM_NOT_EXIST(6519,"不存在关联的Virtual Standard Bom"),
    CURRENT_SPU_PKG_RULE_STATUS_NOT_EFFECTIVE(6520,"当前 spu包装版本规则 状态不在生效状态"),
    SPU_PKG_BOM_NOT_EXIST(6521,"Spu Pkg Bom 不存在"),
    CURRENT_SPU_PKG_BOM_IS_EXIST(6522,"当前 spu包装版本bom 已存在"),
    CURRENT_SPU_BOM_IS_EXIST(6523,"该SPU 已存在SPU BOM"),
    CURRENT_SPU_PKG_BOM_STATUS_NOT_EFFECTIVE(6524,"当前 spu包装版本bom 状态不在生效状态"),
    RELATE_SPU_PKG_BOM_NOT_EXIST(6525,"对应的spu包装版本bom不存在"),
    REVERSE_BOM_EXIST_LOOP(6526,"存在嵌套使用物料"),
    NO_REVERSE_CHECK_METHOD_SELECTED(6527,"反查方式未选择"),
    SPU_PACKAGING_VERSION_BOM_STATUS_INFORMAL(6528,"spu包装版本BOM状态非正式"),
    SPU_PACKAGING_VERSION_BOM_NOT_CREATED(6529,"spu包装版本BOM未创建，请先创建spu包装版本BOM"),
    NEED_ONE_MATERIAL_BOM(6530,"至少需要一个子物料"),
    ACQUIRE_UNIQUE_TASK_ID(6531,"获取唯一Task Id超时"),
    LIQUID_MATERIAL_NOT_NULL(6532,"烟油物料不能为空"),
    MATERIAL_EXPIRE_CANNOT_SUBMIT(6533,"物料已过期,不能提交BOM[物料列表:#{valueMap}]"),
    SPU_PACKAGING_VERSION_BOM_NOT_EFFECTIVE(6534,"包装版本BOM未正式，请联系主数据中心【张玲】处理后再审批"),
    CURRENT_BOM_STATUS_NOT_EFFECTIVE(6500, "当前BOM状态不在生效状态"),
    CURRENT_BOM_EXIST_MATERIAL(6501, "BOM已存在新增物料"),
    EXIST_DUPLICATE_BOM_CODE(6502, "存在多个重复的BOM Code,[重复BOM Code:#{valueMap}]"),
    QUANTITY_CANNOT_BE_EQUAL_ZERO(6503, "用量不允许为0"),
    NODE_ID_IS_DUPLICATE(6504, "Node Id 重复生成,请联系管理员"),
    REQUIRED_PARAMETER_IS_EMPTY(6505, "必填参数不能为空(用量、单位、供应模式、是否半品)"),

    //变更  7000-7499
    ECR_NOT_EXIST(7000, "变更申请单号未输入或者变更申请单号不存在!"),
    ECR_IS_UNAVAILABLE(7001, "Ecr 不可用"),
    ECR_RELATION_NOT_EXIST(7002, "Ecr relation 不存在"),
    ECR_RELATION_HAD_USED(7004, "当前Ecr已经被当前bom 使用"),
    APPLY_CHANGE_REQUEST_OCCUR_EXCEPTION(7005, "Apply change request 出现异常"),
    APPLY_CHANGE_REQUEST_SAVE_OCCUR_EXCEPTION(7006, "Apply change request 保存出现异常"),
    ECR_EXIST_UNCOMPLETED_TASK(7008,"存在未完成的变更任务，无法生成ECN，请先催办变更任务完成后再试"),
    IS_NOT_DRAFT(7009,"非草稿或已撤回状态"),
    ASSOCIATED(7010,"变更单号已经关联ECN"),
    ECN_NOT_EFFECTIVE(7011,"变更申请单未生效，不能生成通知单"),
    ECR_RESTACT_ECN_REPEAT(7012, "变更单号已经生成对应的通知单，无需重复生成"),
    ECN_NOT_EXIST(7013, "ECN单号未输入或者ECN不存在"),
    NOT_CAN_UPDATE_DATE(70014,"已发布的ECN才支持更新"),
    ECR_PROCESS_LOG_IS_NULL(7015,"ecr的变更记录为空，不能生成SAPEcn"),
    FB_IS_NULL(7016,"factoryBomEntityList为空，请检查"),
    BOM_ECN_DTO_LIST_IS_NULL(7017,"bomEcnDtoList,不存在"),
    CHANGE_DATE_DETAIL_NOT_EXIST(7018,"切换日期不存在"),
    ECR_PRODUCT_RECOMMEND_IS_NULL(7019,"成品处理意见不能为空"),
    SAP_RETRACT_FAILED(7020,"SAP撤回失败"),
    SPECIAL_NOT_ALLOW(7021,"除了特批的在生成ECN后还可以继续用ECR单来修改数据，非特批的不允许"),
    ECR_NOT_ALLOW_UPDATE_DATA(7022,"只有审批通过/正式之后的ECR方可被引用于修改数据"),
    ECR_ECN_NOT_ALLOW_UPDATE_DATA(7023,"只有审批通过/正式之后的ECR方可被引用于修改数据,在ECR生成ECN之前，禁止被修改的数据被其他ECR修改数据"),
    ECR_TASK_NOT_COMPLETED(7024,"生成ECN后且ECR关联任务全部完成/关闭的,ECR不允许被使用"),
    ECR_PRODUCT_RECOMMEND_REPEAT(7025,"成品处理意见存在重复的成品编码"),
    EFFECT_SKU_IS_NULL(7026,"变更sku不能为空"),
    ECR_UPDATED_DATA(7028,"当前ECR已修改了系统数据，请联系主数据中心进行强制撤回"),
    ECR_PRODUCT_RECOMMEND_NOT_CONTAINS(7042,"ECR中成品处理意见不包含追溯到的SKU"),
    CHANGING_SKU_CANNOT_BE_EMPTY(7043,"变更SKU不能为空"),
    ECR_UN_PLANNED_REASON(7044,"原计划未考虑当前情况的原因不能为空"),
    EFFECT_SKU_CANNOT_NULL(7045,"受影响SKU不能为空"),
    FINISHED_PRODUCT_HANDLING_OPINION_CANNOT_BE_EMPTY(7046,"成品处理意见不能为空"),
    THE_HANDLING_OPINION_FOR_THE_ECR_CODE_AND_FINISHED_PRODUCT_CODE_DOES_NOT_EXIST(7047,"变更申请单号和成品编码的处理意见不存在"),
    THE_HANDLING_OPINION_FOR_THE_ECR_DOES_NOT_EXIST(7048,"变更申请单号的处理意见不存在"),
    THE_HANDLING_OPINION_FOR_THE_CHANGE_NOTICE_NUMBER_DOES_NOT_EXIST(7049,"变更通知单号的处理意见不存在"),
    CHANGE_SKU_WITH_DUPLICATE_CODES_FOR_MATERIALS(7050,"变更SKU中物料存在重复编码"),
    THE_SWITCHING_TIME_OF_HARD_CUTTING_CANNOT_BE_EMPTY(7051,"固定日期切换的切换时间不能为空"),
    THE_CODE_IN_THE_SKU_CHANGE_DOES_NOT_EXIST_IN_THE_FACTORY_BOM(7052,"生成ecn失败，变更SKU中编码不存在工厂bom中"),
    CHANGE_TYPE_VALUE_ERROR(7053,"变更类型取值错误"),
    THE_PRESENCE_OF_DUPLICATE_FINISHED_PRODUCT_CODES_IN_THE_SKU_LIST_IS_AFFECTED(7054,"影响SKU列表中存在重复的成品编码"),
    FAILED_TO_CREATE_EXCEL(7055,"创建excel 失败"),
    INFORMAL_ECR_CANNOT_INITIATE_CHANGE_TASK(7055,"非正式的ecr不能发起变更任务"),
    REVOKED_AND_NOT_ALLOWED_TO_PUBLISH(7056,"已撤回不允许发布"),
    ECR_IS_WITHDRAWN(7057,"该数据已经是已撤回状态"),
    ECN_PUBLISHING(7058,"变更通知单正在发送中，请稍后再试"),
    THE_SAME_VERSION_EXIST_MULTIPLE_DATA(7059,"同一个版本存在多条数据"),
    THIS_ECR_HAS_MODIFIED_THE_CURRENT_DATA(7060,"该ecr已经修改过当前数据"),
    CHANGE_DATA_NOT_EXIST(7061,"变更中数据不存在"),
    CHECK_VERSION(7062, "当前ECR修改过的数据非最新版本，不支持撤回。"),
    CHANGE_MASTER_DATA_NOT_NULL(7063, "变更主数据不能为空"),
    UNIQUE_IDENTIFICATION_NOT_NULL(7063, "唯一标识不能为空"),
    MASTER_DATA_NOT_NULL(7064, "变更数据字段记录表为空"),
    CHECK_BY_MASTER_CHANGE(7065, "该物料没有被ECR的变更SKU使用，无法进行变更"),
    //规则 7500-7999
    RULE_EDIT_DRAFT_STATUS(7500,"只有状态为“草稿”的，可编辑","Only  \"Draft\" can be edited"),
    RULE_CHECK_UNIQUE_CGY_CMF(7501,"已存在品类CMF版本规则","Rule already exists"),
    RULE_CHECK_UNIQUE_CGY_PKG(7502,"已存在品类包装版本规则","Rule already exists"),
    RULE_CHECK_UNIQUE_SPU_PKG(7503,"已存在SPU包装版本规则","Rule already exists"),
    RULE_CHECK_UNIQUE_SPU_CLO(7504,"该SPU口味已存在颜色规则","Rule already exists"),
    RULE_NOT_EXIST(7505,"规则不存在","Rule does not exist"),
    CURRENT_RULE_STATUS_IS_MODIFYING(7506,"当前规则正在变更","This rule has been modifying"),
    CURRENT_RULE_STATUS_NOT_EFFECTIVE(7507,"只有状态为“临时、正式”，可进行变更","Only the \"Temporary\" or \"Formal\" data can be modified"),
    CURRENT_RULE_STATUS_IS_DISABLE(7508,"当前规则已停止","This rule is abandoned"),
    CURRENT_RULE_STATUS_NOT_DISABLE(7509,"只有状态为“临时、正式、变更中”的，可停用","Only \"Temporary\", \"Formal\", or \"In Modification\" data can be deactivated"),
    RELATE_RULE_STATUS_NOT_EFFECTIVE(7510,"关联的spu包装版本规则不是正是状态","The associated  PKG version rule by SPU is not active"),
    CATEGORY_PKG_LISTING_AREA_CERTIFICATION_REQUIRE_IS_EMPTY(7511,"对应品类包装规则中的上市区域认证要求字段为空","Market registeration requirement is not found in the relative Category-PKG version rules, please contact master data administration"),
    CATEGORY_AND_CMF_VERSION_CANNOT_BE_MODIFIED(7512,"品类和CMF版本不能修改","Category and CMF versions cannot be modified"),
    CATEGORY_AND_PACKAGING_VERSION_CANNOT_BE_MODIFIED(7513,"品类和包装版本不能修改","Category and PKG versions cannot be modified"),
    THE_VALUE_OF_THE_PACKAGING_VERSION_IS_EMPTY(7514,"包装版本规则编码拼接时，包装版本的值为空","The value of the PKG version is empty when concatenating the PKG version rule code"),
    SPU_AND_PACKAGING_VERSIONS_CANNOT_BE_MODIFIED(7515,"spu和包装版本不能修改","SPU and PKG versions cannot be modified"),
    PACKAGING_SPECIFICATIONS_ALREADY_EXIST(7516,"包装规格已存在","PKG specifications already exist"),
    INFORMAL_CMF_RULE_STATUS_FOR_CATEGORY(7517,"品类cmf规则状态非正式","Category CMF rule is not active"),
    CATEGORY_CMF_RULE_NOT_CREATED(7518,"品类cmf规则未创建，请先创建cmf规则","Category CMF rule not found, please set the rule first"),
    SPU_PACKAGING_VERSION_RULE_STATUS_INFORMAL(7519,"spu包装版本规则状态非正式","SPU PKG version rule  is not active"),
    SPU_PACKAGING_VERSION_RULE_NOT_CREATED(7520,"spu包装版本规则未创建，请先创建","SPU PKG version rule not found, please set the rule first"),
    PK_CMF_AND_SKU_APPLY_CATEGORY_OBTAIN_CMF_RULES_ARE_EMPTY(7521,"包装版本规则cmf版本和新品申请品类获取cmf规则为空","Category CMF rule not found, please set the rule first"),
    CATEGORY_PACKAGING_RULE_HAS_NOT_BEEN_CREATED(7522,"对应的品类包装规则未创建","PKG version rules by Category not found, please set the rule first"),
    FLAVOR_SERIES_MANDATORY(7523,"口味系列为必填项","Flavor series is mandatory"),
    THIS_FLAVOR_SERIES_ALREADY_EXISTS(7524,"该口味系列已存在","Flavor series already exists"),
    CHANGE_EXPLAIN_URL_NOT_NULL(7525,"当部门类型为前、中台，变更说明不能为空","Change explain url cannot be empty"),
    MISSING_FIELD_ANNOTATION(7526,"字段注解缺失"),
    ECN_NOTICE_DETAIL_NOT_EXIST(7527,"ecn_notice_detail数据不存在"),
    // 流程
    PROCESS_TASK_SETTING_NON_EXIST(8000,"流程人员配置中不存在当前activityId"),
    NOT_EXIST_PROCESS_DEFINITION(8001,"流程定义不存在!请先启动流程"),
    ONLY_ONE_BUSINESS_DATA(8002,"当前业务数据已启动流程,请不要重复启动"),
    TASK_NOT_EXIST(8003,"该任务不存在或未到执行节点"),
    CANT_ASSIGN_OTHERS_TASK(8004,"当前用户只能改派自己的任务"),
    MUST_NEED_PROCESS_CODE(8005,"请补充流程编码"),
    PROCESS_RUN_LOG_NOT_EXITS(8006,"流程启动记录不存在"),
    SUPPLE_DELETE_PROCESS_RUN_LOG_REASON(8007,"补充删除流程原因"),
    LACK_TASK_DESC(8008,"缺少任务描述"),
    GET_VIEW_TASK_URL_FAIL(8009,"获取查看任务链接失败"),
    LACK_TASK_CODE(8010,"缺少任务编码"),
    CURRENT_ROLE_HAVE_NO_USERS(8011,"当前角色下没有任何用户"),
    PROCESS_BUSINESS_DATA_ILLEGAL(8012,"流程下业务参数非法"),
    TASK_CODE_NOT_EXIST(8013,"任务编码不存在"),
    PROCESS_SETTING_NOT_EXIST(8014,"流程中人员配置不存在"),
    PROCESS_LACK_SETTING(8015,"流程中人员配置没有对应的分配人表达式"),
    TASK_STATUS_DOES_NOT_SUPPORT_DELEGATION(8016,"任务当前状态不支持委派"),
    LACK_TASK_ASSIGNEE(8017,"缺少任务处理人,请重新委派处理人"),
    LACK_TASK_ID(8018,"缺少任务ID"),
    TASK_HAVE_FINISHED(8019,"任务已完成！请不要重复操作"),
    SUPPLE_TASK_PARAMETER(8020,"请完善参数"),
    TASK_CANT_ASSIGNED(8021,"任务已完成！不能重新委派处理人"),
    SUPPLE_TASK_ASSIGNEE(8022,"请补充任务处理人"),
    TASK_RULE_NOT_EXIST(8023,"任务流程人员配置不存在"),
    TASK_RULE_DETAIL_NOT_EXIST(8024,"任务流程配置表明细不存在"),
    TASK_RULE_ON_STATUS_CAN_NOT_DELETE(8025,"任务流程人员配置启用状态不支持删除"),
    TASK_RULE_DETAIL_CAN_NOT_NON(8026,"任务流程配置明细不能为空"),
    PROCESS_RECORD_NOT_EXIST(8027,"流程定义记录不存在"),
    LACK_PROCESS_INSTANCE_ID(8028,"缺少流程实例ID"),
    LACK_ROLLBACK_ID(8029,"缺少流程回滚点ID"),
    TASK_RULE_CONDITION_TYPE_NOT_CONFIG(8030,"流程规则人员配置类型未配置"),
    TASK_RULE_DATA_ERROR(8031,"流程规则人员配置详情数据错误"),
    TASK_RULE_IS_OFF(8032,"流程规则人员配置未启用"),
    TASK_RULE_THERE_ARE_MULTIPLE(8033,"流程规则人员配置存在多个符合条件的结果"),
    TASK_RULE_NO_MATCHING_RESULT_FOUND(8034,"流程规则人员配置没有符合条件的结果[请到流程人员配置中,配置规则:#{valueMap}]"),
    LACK_BUSINESS_TAG(8035,"无法获取业务配置人员,请补充业务参数"),
    TASK_RULE_DETAIL_USER_IS_EMPTY(8036,"任务规则人员不能为空"),
    PROCESS_LACK_USER_RULE(8037,"流程配置中没有配置流程人员规则"),
    USER_SETTING_TYPE_INCONSISTENT(8038,"人员配置维度与人员配置不一致[节点:#{valueMap}]"),
    CANT_HANDLE_DIFFERENT_PROCESS_DIFFERENT_TASK(8039,"请选择相同流程、相同类型、相同节点类型的任务"),
    CANT_BATCH_OPERATE_CURRENT_PROCESS_TASK(8041,"不允许被批量处理"),
    LACK_BUSINESS_DATA(8042,"缺少业务数据"),
    TASK_NOT_SELECTED(8043,"未选中任务"),
    THE_SELECTED_TASK_HAS_NO_TASKS_THAT_CAN_BE_CLOSED(8044,"选中任务没有可以关闭的任务"),
    NON_DEPLOY_PROCESS(8045,"请先发布流程"),
    TASK_USER_RULE_NAME_ALREADY_EXISTS(8046,"流程人员规则名称已存在"),
    USER_NOT_EXIT(8047,"业务配置下的任务处理人不存在"),
    TASK_RULE_EXPRESSION_NO_VALUE(8048,"请完善流程规则人员配置下表达式对应的值(表达式:#{valueMap})"),
    CHECK_TASK_BELONG_CURRENT_USER(8049,"请检查任务是否归属当前用户"),
    USER_SETTING_TYPE_DESIGN_INCONSISTENT(8050,"请检查人员配置维度是否符合流程图设计[节点:#{valueMap}]"),
    LACK_SYSTEM_TASK_SETTING(8051,"缺少流程系统任务节点配置"),
    SUPPLE_PROCESS_SETTING(8052,"请补充流程配置[节点类型:#{valueMap}]"),
    ONLY_SUPPORT_NOTIFY_NODE_EXPORT(8053,"目前仅支持导出节点类型为提醒节点的任务"),
    LACK_TASK_EXPORT_HANDLER(8054,"该任务不支持导出"),
    GET_TASK_EXPORT_KEY(8055,"获取任务导出KEY异常"),
    CHANGE_SKU_NOT_EXIST(8056,"变更sku不存在"),
    PROCESS_RECORD_ALREADY_EXISTS(8057,"流程定义记录已存在"),
    TASK_CAN_ASSIGNED_OTHERS(8058,"请委派任务给其他人(新委派的任务处理人和当前的任务处理人不能一致)"),
    LACK_NODE_TYPE_SETTING(8059,"缺少节点类型配置"),
    MUST_NEED_PROCESS_CODE_WITH_DETAIL(8060,"请补充流程编码(流程编码:#{valueMap})"),
    NOT_EXIST_TO_DO_TASK(8061,"暂不存在待处理的任务"),
    NOT_SUPPORT_CURRENT_PROCESS(8061,"当前流程不支持按项目成员配置人员维度"),
    CURRENT_SPU_HAVE_NO_USER(8062,"当前SPU没有项目成员"),
    CANT_GENERATE_COMPARE_RESULT(8063,"当前业务数据不足，无法生成数据对比结果"),
    /**
     * 文档管理
     */

    FILE_STATUS_IS_NOT_DRAFT(9000,"当前文档非草稿状态"),
    FILE_REQUIRED_MISS(9001,"请先完善文档信息"),
    FILE_STATUS_IS_NOT_CONTROLLED(9002,"当前文档非受控状态"),
    FILE_IS_NOT_EXIST(9003,"文档不存在"),
    FILE_DRAFT_NOT_EXIST_OR_HAS_MULTIPLE(9004,"草稿状态的文档不存在或者存在多条"),
    /**
     * 批量文件上传
     */
    FILE_TYPE_NOT_SUPPORT(9201,"不支持的文件类型"),
    FILE_NAME_NOT_SUPPORT(9202,"不支持的文件名"),
    FILE_SIZE_NOT_SUPPORT(9203,"不支持的文件大小"),
    FILE_NOT_EXIST(9204,"文件不存在"),
    FILE_NOT_EXIST_OR_MULTIPLE(9205,"文件不存在或者存在多条"),
    FILE_NOT_EXIST_OR_MULTIPLE_OR_NOT_MATCH(9206,"文件不存在或者存在多条，或者文件类型不匹配"),


    /**
     * 国家合规母版设计需求
     */
    NO_DESIGN_FILE_UPLOAD(9401, "未上传设计文件"),
    CURRENT_STATUS_ERROR(9402, "当前状态不允许该操作"),
    CATEGORY_IS_EMPTY(9403, "合规母版品类为空"),


    /**
     * sku包装设计与cmf设计 10001-11000
     */
    SKU_PKG_NOT_EXIST(10001,"sku包装设计不存在"),
    CMF_DESIGN_NOT_EXIST(10002,"cmf设计不存在"),
    THIS_RECORD_DOES_NOT_EXIST_PLEASE_RESELECT_THE_RECORD_ALLOCATION(10003,"该条记录不存在，请重新选择记录分配"),
    THE_CURRENT_STATUS_IS_NOT_PENDING_ALLOCATION(10004,"当前状态不是待分配"),
    CURRENT_STATUS_NOT_BATCH_EDIT(10005," 仅处于待设计、驳回后待设计状态可批量编辑"),
    GENERATE_BOM_VIEW_DATA_NOT_EXIST(10006,"标准bom详情数据中物料类型为 [#{param}] 不存在"),
    SIMPLE_ECR_DOES_NOT_SUPPORT_CHANGES_PKG(10007,"简易ECR暂不支持变更包装设计需求"),
    SKU_CODE_IS_EMPTY(10008,"sku编码为空"),
    SKU_CODE_REPEAT(10009,"sku编码重复"),
    PROCESS_NOT_EXIST_OR_MULTIPLE(10010,"进行中的包装设计流程不存在，或者存在多条"),
    FILE_TYPE_ERROR(10011,"文件类型错误"),
    THIS_DATA_RECORD_HAS_MULTIPLE_PROCESSES(10012,"该条设计稿同时存在于多个流程"),
    PROCESS_HAS_PASSED_THE_UPLOAD_NODE(10013,"流程已过上传节点"),
    //包含当前不支持分配设计师的选项，请检查
    INCLUDES_THE_OPTION_OF_NOT_SUPPORTING_DESIGNER_ALLOCATION_AT_PRESENT(10014,"包含当前不支持分配设计师的选项，请检查"),
    BATCH_SELECTED_SKU_PKG_HAS_INVALID_DATA(10015,"批量选择的包装设计中存在无效的数据，请检查"),
    /**
     * 文件上传类型错误
     */
    FILE_UPLOAD_TYPE_ERROR(10016,"文件上传类型错误"),
    /**
     * 找不到小盒物料
     */
    SMALL_BOX_MATERIAL_NOT_FOUND(10017,"找不到小盒物料"),
    /**
     * 找不到中盒物料
     */
    MID_BOX_MATERIAL_NOT_FOUND(10018,"找不到中盒物料"),
    /**
     * 找不到中盒和小盒物料
     */
    MIDDLE_AND_SMALL_BOX_MATERIAL_NOT_FOUND(10019,"找不到中盒和小盒物料"),
    /**
     * 未生成BOM信息
     */
    BOM_INFO_NOT_FOUND(10020,"流程未到指定节点，未生成sku包装设计BOM信息"),
    /**
     * 找不到外箱物料
     */
    OUTER_BOX_MATERIAL_NOT_FOUND(10020,"找不到外箱物料"),
    CMF_DESIGN_CANNOT_BE_RETRACTED(10021,"cmf设计当前状态不支持撤回"),
    BATCH_SELECTED_CMF_DESIGN_HAS_INVALID_DATA(10022,"批量选择的cmf设计中存在无效的数据，请检查"),
    CMF_DESIGN_CANNOT_BE_CLOSED(10023,"cmf设计当前状态不支持关闭"),
    CMF_EXTEND_NOT_EXIST(10024,"cmf延展单不存在"),
    WORD_EXCEEDS_THE_MAXIMUM_CHARACTERS_PER_LINE(10024,"单词 [#{param}] 超出每行最大字符数"),
    /**
     * 状态为延展中的数据不能删除
     */
    CANNOT_DELETE_EXTENDING_DATA(10025,"状态为延展中的数据不能删除"),
    /**
     * 数据不存在或被删除
     */
    EXTEND_DATA_NOT_EXIST_OR_DELETED(10026,"延展数据不存在或被删除"),
    /**
     * ai母版文件不存在
     */
    EXTEND_AI_MASTER_FILE_NOT_EXIST(10027,"ai母版文件不存在"),
    /**
     * 延展子表不存在
     */
    EXTEND_FLAVOR_NOT_EXIST(10028,"延展子表不存在"),
    /**
     * 延展的数据需要满足名称和对应颜色值都存在或都不存在
     */
    CMF_EXTEND_FLAVOR_NAME_AND_COLOR_VALUE_NOT_EXIST_OR_EXIST(10029,"延展的数据需要名称和对应颜色值都存在或都不存在"),
    /**
     * 包装延展单不存在
     */
    PACKAGE_EXTEND_NOT_EXIST(10030,"包装延展单不存在"),
    /**
     * 请先上传色卡
     */
    COLOR_CARD_NOT_EXIST(10031,"色卡不存在，请先上传色卡"),
    EXTEND_DATA_NOT_EXIST(10032,"延展数据不存在，请刷新页面之后重试"),
    CANNOT_TERMINATE_NO_EXTENDING_DATA(10033,"没有延展中的数据，无需终止"),
    /**
     * 调用终止接口失败
     */
    TERMINATE_CALL_FAILED(10034,"调用终止接口失败，错误原因：[#{param}]"),
    /**
     * 未找到对应的文件，请确认是否延展完成
     */
    EXTEND_FILE_NOT_EXIST(10035,"未找到对应的文件，请确认是否延展完成"),
    /**
     * 压缩过程出错
     */
    COMPRESS_ERROR(10036,"压缩过程出错"),
    /**
     * 延展接口调用失败
     */
    EXTEND_CALL_FAILED(10037,"调用延展接口失败"),
    /**
     * sku包装设计中的bom数据错误
     */
    SKU_PKG_BOM_DATA_ERROR(10038,"sku包装设计中的bom数据错误"),
    SKU_PKG_NOT_UNIQUE(10039,"sku包装设计中存在重复的sku编码"),
    /**
     * 请在 SKU 信息中补充烟杆颜色或烟弹颜色
     */
    SKU_PKG_SMOKE_PIPE_COLOR_OR_SMOKE_BALL_COLOR_NOT_EXIST(10040,"请在 SKU 信息中补充烟杆颜色或烟弹颜色"),
    /**
     * 请在 SKU 信息中补充烟弹颜色
     */
    SKU_PKG_SMOKE_BALL_COLOR_NOT_EXIST(10041,"请在 SKU 信息中补充烟弹颜色"),
    /**
     * 素材不存在或未受控
     */
    ASSET_NOT_EXIST_OR_NOT_CONTROLLED(10042,"素材不存在或未受控"),
    FILE_NAME_IS_EMPTY(10043,"延展信息缺少文件名 file name 字段，请补充！"),
    /**
     * AI检查需要的文件不存在或被删除
     */
    AI_CHECK_FILE_NOT_EXIST(10044,"AI检查需要的文件不存在或被删除"),
    /**
     * 正在进行AI检查，请不要重复操作
     */
    AI_CHECKING(10045,"正在进行AI检查，请不要重复操作"),
    /**
     * 包装设计需求不存在或已被删除
     */
    PACKAGE_DESIGN_REQUIREMENT_NOT_EXIST_OR_DELETED(10046,"包装设计需求不存在或已被删除"),
    /**
     * 文件均以受控，请点击保存即可
     */
    FILE_IS_CONTROLLED(10047,"文件已受控，请点击保存即可"),
    /**
     * 文档处于变更中，请先审批完再进行变更
     */
    DOCUMENT_IS_CHANGING(10048,"文档处于变更中，请先审批完再进行变更"),
    CURRENT_NODE_NOT_ALLOW_UPLOAD_DRAWING(10049,"[#{param}]当前节点不允许上传图纸"),
    /**
     * 延展子单不存在DXF文件
     */
    DXF_FILE_NOT_EXIST_IN_EXTEND_FLAVOR(10050,"延展子单[#{param}]不存在DXF文件"),
    /**
     * 延展子单不存在PDF文件
     */
    PDF_FILE_NOT_EXIST_IN_EXTEND_FLAVOR(10051,"延展子单[#{param}]不存在PDF文件"),
    /**
     * 标签集 11000-11500
     */
    LABEL_SET_NOT_EXIST(11001,"标签集不存在"),
    LABEL_SET_STATUS_IS_MODIFYING(11002,"当前标签集正在变更"),
    LABEL_SET_STATUS_NOT_EFFECTIVE(11003,"只有状态为“临时、正式”，可进行变更"),
    THE_GENERATED_LABEL_SET_ENCODING_AND_LABEL_SET_NAME_ARE_EMPTY(11004,"生成的标签集编码和标签集名称为空"),
    THE_LABEL_APPLICATION_DOES_NOT_EXIST(11005,"该标签申请单不存在"),
    NO_LABEL_MATERIALS_GENERATED(11006,"没有生成标签物料"),
    LABEL_BASIC_INFO_NOT_EXIST(11007,"标签集申请不存在"),
    LABEL_SET_RELATION_APPLY_NOT_EXIST(11008,"标签集信息表/关联产品不存在"),
    THE_PACKAGING_PRODUCT_COLUMN_CANNOT_BE_EMPTY(11009,"产品线类别为 pod、pod pro、pod pro 2 时包装规格不能为空"),
    LABEL_APPLY_RESULT_NOT_EXIST(11010,"标签物料不存在"),
    LABEL_DESIGN_NOT_EXIST(11500,"标签示意图不存在"),
    LABEL_EXTENSION_FAILED(11501,"标签延展失败，接口未返回延展图片"),
    BARCODE_NOT_EXIST(11502,"69码不存在"),
    BARCODE_IS_NULL(11503,"69码为空"),
    NO_MATCHING_SKU_FOUND(11501,"没有与条件匹配的sku"),

    /**
     * 69码对应对应的Ai文件不存在
     */
    BARCODE_AI_FILE_NOT_EXIST(11504,"69码对应的Ai文件不存在"),
    /**
     * 69码对应的png图片不存在，请输入正确的69码或者在OSS上上传对应的文件
     */
    BARCODE_PNG_FILE_NOT_EXIST(11505,"未获取到该产品的图纸，请联系设计师上传后再添加示意图"),
    /**
     * 标签申请已提交，请勿重复提交
     */
    LABEL_APPLY_SUBMITTED(11506,"标签申请已提交，请勿重复提交"),
    /**
     * ai文件或pdf文件不存在
     */
    AI_OR_PDF_FILE_NOT_EXIST(11507,"ai文件或pdf文件不存在"),
    /**
     * 业务类型错误
     */
    BUSINESS_TYPE_ERROR(11508,"业务类型错误"),
    /**
     * 请求状态错误
     */
    REQUEST_STATUS_ERROR(11509,"请求状态错误"),



    /**
     * 标签集申请 11501-12000
     */
    /**
     * spu可选颜色、spu口味颜色 11501-12000
     */
    POD_COLOR_REQUIRED_PLEASE_CONFIRM(11501,"烟弹颜色为必填，若无值可选，请联系PM/PDM补充规则",
            "The color of the vape cartridge is required. If no value is available, please contact the PM/PDM to supplement the rules"),
    SPU_Attribute_ALREADY_EXISTS(11503,"SPU属性值已存在","The SPU attribute already exists"),
    THE_SPU_FLAVOR_COLOR_RULE_ALREADY_EXISTS(11504,"SPU口味颜色规则已存在","The SPU flavor color rule already exists"),
    SPU_NAME_AND_FLAVOR_ONTOLOGY_HAVE_DUPLICATE_DATA(11505,"spu名称和口味本体存在重复，请检查","The SPU name and flavor ontology have duplicate data, please check"),
    SPU_OPTIONAL_COLOR_RULE_NOT_CREATED(11506,"spu可选颜色规则未创建，请先创建","The SPU optional color rule has not been created, please create it first"),
    SPU_Attribute_NOT_EXISTS(11507,"SPU属性值不存在","The SPU attribute does not exist"),
    //spu属性清单类型不能为空
    SPU_ATTRIBUTE_LIST_TYPE_CANNOT_BE_EMPTY(11508,"spu属性清单类型不能为空","The SPU attribute list type cannot be empty"),
    SPU_ATTRIBUTE_LIST_DATA_BLOCK_CANNOT_BE_EMPTY(11509,"spu属性清单数据块不能为空","The SPU attribute list data block cannot be empty"),
    //该SPU已经维护过清单，请查询 SPU的对应档位清单并进入编辑
    SPU_ATTRIBUTE_LIST_MAINTAINED(11510,"该SPU已经维护过清单，请查询 SPU的对应档位清单并进入编辑"),
    /**
     * 烟油适配 12001-12500
     */
    TOBACCO_OIL_ADAPTATION_TASK_CREATION_FAILED(12001,"烟油适配任务创建失败"),
    THE_REQUIREMENT_CODE_FOR_TOBACCO_OIL_ADAPTATION_CANNOT_BE_EMPTY(12002,"烟油适配需求编码不能为空"),
    BATCH_ALLOCATION_MUST_HAVE_NO_TASK_ALLOCATION_FOR_ALL_REQUIREMENTS(12003,"批量分配必须所有需求都未进行过任务分配"),
    THE_DEMAND_FOR_TOBACCO_OIL_ADAPTATION_CANNOT_BE_EMPTY(12004,"烟油适配需求不能为空"),
    NO_RECORD_OF_OIL_ADAPTATION_EXISTS(12005,"烟油适配记录不存在，请重新选择记录进行编辑"),
    NON_DRAFT_STATUS_CANNOT_BE_EDITED(12006,"非草稿状态不可编辑"),
    THE_TOBACCO_OIL_ADAPTATION_DEMAND_STATUS_MUST_BE_SUBMITTED(12013,"烟油适配需求状态须为已提交"),
    THERE_IS_NO_DEMAND_FOR_TOBACCO_OIL_ADAPTATION(12015,"烟油适配需求不存在"),

    /**
     * Spu bom 12501-13000
     */
    SPU_MEMBERS_NOT_MAINTAINED(12501,"任务成员表中spu成员未维护"),

    /**
     * 口味本体
     * 13001-13500
     */
    THE_FLAVOR_ONTOLOGY_ALREADY_EXISTS(13001,"口味本体已经存在"),
    THE_LIST_OF_TASTE_REQUIREMENTS_CORRESPONDING_TO_THE_FLAVOR_ONTOLOGY_IS_EMPTY(13002,"口味本体对应的口味需求列表为空"),
    FAILED_TO_GENERATE_FLAVOR_ONTOLOGY_CODE(13003,"生成口味本体编码失败"),
    FLAVOR_CATEGORY_CODE_MUST_BE_TWO_DIGITS(13004,"口味一级分类编码必须为两位数"),
    FLAVOR_SUB_CATEGORY_CODE_MUST_BE_FOUR_DIGITS(13005,"口味二级分类编码必须为四位数"),
    /**
     *口味需求
     * 13501-14000
     */
    THE_FLAVOR_REQUEST_DOES_NOT_EXIST(13510,"口味需求不存在"),
    COMPLETED_REQUIREMENT_CANNOT_BE_CLOSED(13511,"已完成需求不可关闭"),
    THE_REFERENCE_SUPPLIER_MODEL_IS_NOT_EXIST(13520,"参考供方型号不存在"),
    FLAVOR_REQUEST_STATUS_ERROR(13521,"口味需求状态错误"),
    /**
     *SKU退市
     * 14000-14500
     */
    DELISTING_REQUEST_ADD_SKU_ERROR(14000,"创建退市申请错误，SKU不存在或者SKU编码解析失败"),
    DELISTING_REQUEST_ADD_SKU_IS_NOT_EXIST(14002,"创建退市申请单错误，输入的批量SKU编码中的部分在SKU表中不存在"),
    DELISTING_REQUEST_ADD_SKU_STATUS_IS_ERROR(14003,"创建退市申请单错误，输入的批量SKU编码中的部分SKU状态为退市中或者已退市"),
    DELISTED_ADD_REQUEST_IS_NOT_EXIST(14004,"创建退市单失败，传入的的退市申请单id对应的数据不存在"),
    NO_DATA_SELECTED_FOR_ADJUSTMENT(14005,"未选中需要调整的数据"),
    DELISTED_IMPORT_INVENTORY_ADJUSTMENT_CODE_CANNOT_NULL(14006,"系统检查到导入数据中存在退市ID为空的数据"),
    DELISTED_IMPORT_INVENTORY_ADJUSTMENT_CODE_ERROR(14007,"系统检查到导入数据中存在错误的退市ID数据"),
    DELISTED_SYNC_ERP_DATA_IS_EMPTY(14008,"同步ERP失败，没有需要同步的数据"),
    REQUEST_CLOSE_NO_SELECT_DATA(14009,"未选中需要关闭的数据，请先选中"),
    THERE_ARE_NON_PENDING_DATA_IN_THE_SELECTED_DATA(14010,"只能选择待审核状态的数据进行关闭，请刷新页面冲洗选择"),
    SYNC_FAILED_ID_IS_EMPTY(14012,"同步失败，传入的主键为空"),
    NO_DATA_SELECTED_FOR_CLEANING(14013,"未选中需要进行账目清理的数据"),
    THERE_ARE_NON_CLEANING_LOADS_PRESENT(14014,"存在非待清理装填的数据"),
    DELISTED_REQUEST_IS_NOT_EXIST(14015,"退市申请单不存在"),
    DELISTED_INVENTORY_ADJUSTMENT_IS_EMPTY(14016,"退市申请库存调整数据为空"),
    DELISTED_IS_NOT_EXIST(14017,"退市单不存在"),
    DELISTED_INVENTORY_REQUEST_IS_NOT_EXIST(14018,"退市申请品类对应的必填库存未填"),
    DELISTED_STATUS_ERROR(14019,"退市单状态错误"),


    /**
     * 14501-15000
     */
    FACTORY_CODE_ALREADY_EXISTS(14501,"工厂编码已存在"),
    IMPORT_FACTORY_CODE_IS_WRONG(14502,"导入的工厂编码[#{param}]有问题，请重新导入"),

    /**
     * 15000-15500
     */
    THE_PRODUCT_REGISTRATION_CONFIGURATION_DOES_NOT_EXIST(15001,"产品注册配置不存在"),
    REGISTRATION_DIMENSION_CANNOT_BE_EMPTY(15002,"注册维度不能为空"),
    THE_PRODUCT_REGISTRATION_APPLY_DOES_NOT_EXIST(15003,"产品注册申请不存在"),
    NON_DRAFT_STATUS_CANNOT_BE_DELETED(15004,"非草稿状态不可删除"),
    REG_CONF_EXIST(15005,"注册项已存在"),
    THIS_ITEM_HAS_ALREADY_BEEN_REGISTERED(15006,"根据系统规则当前无需申请注册，请咨询合规同事是否已有其他同事注册过"),
    PRODUCT_REGISTRATION_APPLY_DOES_NOT_EXIST(15007,"产品注册申请单不存在"),
    THE_CURRENT_STATUS_DOES_NOT_ALLOW_CLOSING_APPLICATIONS(15008,"当前状态不允许关闭申请"),
    NO_CONFIGURATION_ITEMS_MATCHING_THE_CURRENT_CONDITIONS(15009,"根据当前条件没有符合的配置项"),
    REGISTRATION_SKU_CANNOT_BE_EMPTY(15010,"注册费用计算是SKU不能为空"),
    //费用清单不能为空
    REGISTRATION_COST_LIST_CANNOT_BE_EMPTY(15011,"注册费用清单不能为空"),

    /**
     * 15501-16000
     */
    SPU_OP_CATEGORY_DOES_NOT_EXIST(15501,"SPU运营分类不存在"),
    FIELD_NOT_EXIST_PARAMETER(15502,"参数中不存在该字段，fieldName:[#{param}]"),
    /**
     * spu运营分类父级分类不存在
     */
    SPU_OP_CATEGORY_PARENT_IS_NULL(15502,"SPU运营分类父级为空"),
    SPU_OP_CATEGORY_NAME_IS_NULL(15503,"SPU运营分类名称为空"),
    SPU_OP_CATEGORY_NAME_EXISTS(15504,"该分类已存在"),

    //画板相关异常
    LACK_ELEMENTS(16001, "画板缺少元素"),
    LACK_IMAGE_INFO(16002, "缺少图纸信息"),
    DRAW_NOT_EXIST(16003, "画板不存在"),
    CREATE_BARCODE_FAIL(16004, "条形码生成失败，请检查69码之后重试，或联系技术管理员"),
    BARCODE_NOT_EMPTY(16005, "条形码不能为空"),
    ILLEGAL_BARCODE(16006, "非法条形码"),
    LACK_LABEL_INFO(16007, "缺少标签信息"),
    /**
     * 调用ai接口失败
     */
    AI_FAIL(16008, "调用ai接口失败"),
    DO_SPOT_IMAGE_ERROR(16009, "调用图文识别接口失败,uid:#{valueMap}"),


    /**
     * spus属性
     * 16501-17000
     */
    //spu属性对应的spu油仓数量未维护
    SPU_OIL_TANK_NOT_MAINTAINED(16501,"SPU属性对应的SPU油仓数量未维护"),
    //该SPU剩余xx个油仓可维护，请检查
    SPU_REMAINING_OIL_TANKS_CANNOT_BE_MAINTAINED(16502,"该SPU剩余[#{param}]个油仓可维护，请检查"),
    SPU_OIL_TANK_NOT_EXIST(16503,"该SPU对应的油仓不存在"),
    SPU_POWER_LEVEL_NOT_EXIST(16504,"该SPU对应的功率挡不存在"),


    /**
     * 发布工厂字段配置
     * 17001-17500
     */
    FACTORY_INFO_IS_NULL(17001,"工厂信息为空"),
    TEMPLATE_NOT_EXIST(17002,"模板不存在"),
    //启用的模板中包含的共仓在已在其他模板中
    FACTORY_EXIST_IN_OTHER_TEMPLATE(17003,"启用的模板中包含的共仓在已在其他模板中"),
    //模板名称已经存在
    TEMPLATE_NAME_EXISTS(17004,"模板名称已经存在"),
    //工厂未启用或不存在
    FACTORY_NOT_ENABLED_OR_NOT_EXIST(17005,"工厂未启用或不存在"),

    /**
     * 17501-17600
     */
    //导入的物料编码有问题，请重新导入
    IMPORT_MATERIAL_CODE_IS_WRONG(17501,"导入的物料编码[#{param}]有问题，请重新导入"),
    //导入的物料编码和包装等级重复
    IMPORT_MATERIAL_CODE_AND_PACKAGING_GRADE_REPEAT(17502,"导入的物料编码[#{param}]和包装等级重复"),
    FLAVOR_ONTOLOGY_DOES_NOT_EXIST(17503,"(#{param})口味本体不存在;"),
    SKU_COLUMN_IMPORT_UPDATE_FIELD(17504,"指定列导入更新口味字段前，请确保SKU中存在该口味信息"),

    /**
     * 17601-18000
     */
    //元数据
    HAVE_ALREADY_USED_FIELD_AND_CANNOT_BE_DELETED(17601,"存在已使用该字段的表单，无法删除"),
    INCONSISTENT_NUMBER_OF_LAYERS_AND_DETAILED_SURFACE_LAYERS(17602,"层数和明细表层数不一致"),
    CATEGORY_NOT_EXISTS(17603,"分类不存在"),

    /**
     * 18000-18500
     */
    //运输鉴定报告
    SELECT_SAME_SKU_SPU_AND_PACKAGE_VERSION(18001,"请选择相同的SPU+包装版本的SKU"),
    IDENTIFY_REPORT_CANNOT_BE_CLOSED(18002, "该状态不支持关闭"),
    CATEGORY_FILE_TYPE_NOT_CONFIGURED(18003,"品类对应的文件类型未配置，请联系管理员"),
    //该品类下需要的文件不全
    CATEGORY_FILE_NOT_COMPLETE(18004,"该品类下需要的文件不全"),
    //该品类下的文件超过10份
    CATEGORY_FILE_EXCEED_10(18005,"该品类下的文件超过10份"),
    SELECT_AT_LEAST_ONE_SKU(18006,"请至少选择1个SKU"),
    // 报告类型不能为空
    REPORT_TYPE_CANNOT_BE_EMPTY(18007,"报告类型不能为空"),
    SELECT_SAME_SPU_AND_PACKAGE_VERSION(18008,"请选择相同的SPU+包装版本"),
    ;

    private Integer code;
    private String msg;
    private String enMsg;

    CommonStateCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    CommonStateCode(Integer code, String msg, String enMsg) {
        this.code = code;
        this.msg = msg;
        this.enMsg = enMsg;
    }

    public static CommonStateCode ofMsg(String msg) {
        for (CommonStateCode commonStateCode : CommonStateCode.values()) {
            if(commonStateCode.msg.equals(msg)) {
                return commonStateCode;
            }
        }
        return null;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getEnMsg() {
        return enMsg;
    }

    public void setEnMsg(String enMsg) {
        this.enMsg = enMsg;
    }

    public static CommonStateCode ofCode(Integer code){
        for(CommonStateCode commonStateCode : values()){
            if(commonStateCode.getCode().equals(code)){
                return commonStateCode;
            }
        }
        return CommonStateCode.ERROR;
    }

    @Override
    public String toString() {
        return "{\"code\":\"" + code + "\",\"msg\":\"" + msg + "\"}";
    }
}
