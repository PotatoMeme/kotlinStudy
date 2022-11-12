package com.potatomeme.modernandroid.docs

/** WorkManager */
/** 안드로이드의 백그라운드 작업 */
//실행 시점에 따른 분류
//Exact Timing : 즉시 처리되어야 하는 작업
//Deferrable : 처리를 위한 조건이 만족될 때까지 기다릴 수 있는 작업

//실행 완료 여부에 따른 분류
//Best-Effort : 처리를 위해 노력하지만 취소될 수도 있는 작업
//Guaranteed Execution : 앱이 종료되거나 기기가 재부팅되어도 수행되어야 하는 작업

//                      Exact Timing        Deferrable
//Best-Effort           ThreadPool          ThreadPool
//GuaranteedExecution   ForegroundService   JobScheduler, JobDispatcher, AlarmManager, BroadcastReceivers


/** 안드로이드 백그라운드 API의 변천 과정 */
// API 18 : AlarmManager
// ,시스템의 BroadCastReceiver를 등록하여 앱에서 알람 메니저로 알람을 전달하면 호출되는 서비스로 백그라운드 동작을 실행하였음

// API 19 : AlarmManager (X)
// , 기기의 wakeUp 알람과 베터리 소모를 최소화하기 위하여 시스템이 알람 타이밍을 병경할수있게됨
// -> AlarmManager가 정확한시간에 동작하지 않게됨

// Google I/O 2014 - Introduction to Project Volta
// 전력 소모를 줄일수있는 다섯가지 기술
//  Lazies first
//  JobScheduler
//  , 백그라운드 작업의 실행 타이밍을 앱이아닌 시스템이 판단하게 함으로서 베터리시간을 갉아 먹는 무분별한 백그라운드 작업을제한
//  The ART runtime
//  Battery Historian
//  Battery Saver mod

/** 안드로이드 백그라운드 API의 변천 과정 */
//API 23(Marshmallow) : Doze and App Standby
//API 24(Nougat) : Doze on-the-go, Limited implicit broadcasts
//API 26(Oreo) : Background service limitations, Implicit Broadcast Exceptions, Release cached wakelocks
//API 28(Pie) : App Standby Buckets, Battery Saver mode
//API 29(Quince Tart) : Restrictions on starting activities
//API 30(Red Velvet Cake) : Background location access
//API 31(Snow Cone) : Foreground service launch restrictions, Phantom Processes

/** Firebase JobDispatcher */
//버전에따른 백그라운드 관리정책을 적용하는것은 복잡하고 까다로움, 작업을 잘못설계한경우 유저에따라서 백그라운드 작업을 수행할수 없는 경우가 생김
//이에따라 구글은 Firebase JobDispatcher를 발표
//API 9+ 사용가능
//AlarmManager 와 JobScheduler 를 알아서 선택
//Google Play Service 필요, 중국쪽은 힘듬

/** WorkManager의 발표 */
//이런한 이유로 2018년 구글에서는 WorkManager를 발표
//Guaranteed, constraint-aware execution
//실행이 보장되며 제약조건을 붙일 수 있습니다.
//예를 들면 네트워크 연결시에만 작업이 처리되도록 할 수 있습니다.

//Respectful of system background restrictions
//장치의 상태를 존중합니다.
//예를들어 앱이 도즈모드일 경우 작업 처리를 위해 기기를 깨우지 않습니다.

//Backwards compatible with or without Google Play Services
//구글 플레이 서비스와 관계없이 동작합니다.

//Queryable
//작업이 실행/대기중인지? 성공/실패했는지 등의 상태조회를 할 수 있습니다.

//Chainable
//작업 A, B 결과에 따라 처리되는 작업 C를 만들고, 다시 C의 결과에 의존하는 작업 D를 만들 수 있습니다.

//Opportunistic
//사용자를 간섭하지 않아도 제약조건이 만족되면 작업이 즉시 실행됩니다

/** WorkManager의 동작 구조 */
//  work
//  if(work.api_version >= 23){
//      useJobScheduler()
//  }else if(app.firebase?.jobDispatcher?.installed ?:false){
//      useFirebaseJobDispatcher()
//  }else{
//      useAlarmManager()
//      useBroadCastReceiver()
//  }
//  execute()

//WorkManager는 만능 라이브러리가 아니며 Deferrable, GuaranteedExecution의 특서을가진 백그라운드작업들을 사용하기위하여 설계됨

/** WorkManager의 useCase */
//UseCase   : Guaranteed execution of deferrable work
//Examples  : Upload logs to your server,Encrypt/Decrypt content to upload/download
//Solution  : WorkManager

//UseCase   : A task initiated in response to an extern event
//Examples  : Syncing new online content like email
//Solution  : FCM + WorkManager

//UseCase   : Continue user-initiated work that needs to run immediately even if the user leaves the app
//Examples  : Music player, Tracking activity, Transit navigation
//Solution  : Foreground Service

//UseCase   : Trigger actions that involve user interactions,like notifications at an exact time.
//Examples  : Alarm clock, Medicine reminder,Notification about a TV show that is about to start
//Solution  : AlarmManager

/** WorkManager의 실행구조 */
//class UploadWorker(appContext: Context, workerParams: WorkerParameters): Worker(appContext, workerParams) {
//  override fun doWork(): Result {
//
//      //Do the work here--in this case, upload the images.
//      uploadImages()
//
//      // Indicate whether the work finished successfully with the Result
//      return Result.success()
//  }
//}

/** WorkManager의 제약조건 설정 */
// Constraints  : NetworkType
// Description  : Constrains the type of network required for your work to run. For example, Wi-Fi (UNMETERED).

// Constraints  : BatteryNotLow
// Description  : When set to true, your work will not run if the device is in low battery mode.

// Constraints  : RequiresCharging
// Description  : When set to true, your work will only run when the device is charging.

// Constraints  : DeviceIdle
// Description  : When set to true, this requires the user’s device to be idle before the work will run.
//                This can be useful for running batched operations that might otherwise have a negative
//                performance impact on other apps running actively on the user’s device.

// Constraints  : StorageNotLow
// Description  : When set to true, your work will not run if the user’s storage space on the device is too low

/** WorkRequest 만들기 */
//val constraints = Constraints.Builder()
//    .setRequiredNetworkType(NetworkType.UNMETERED)
//    .setRequiresCharging(true)
//    .build()
//
//val uploadWorkRequest: WorkRequest =
//        OneTimeWorkRequestBuilder<UploadWorker>()
//            .setConstraints(constraints)
//            .build()

/** WorkRequest 제출 */
//WorkManager
//    .getInstance(myContext)
//    .enqueue(uploadWorkRequest)
//참고 : https://medium.com/androiddevelopers/workmanager-basics-beba51e94048

/** Work States 확인하기 */
//// by id
//workManager.getWorkInfoById(syncWorker.id) // ListenableFuture<WorkInfo>
//
//// by name
//workManager.getWorkInfosForUniqueWork("sync") // ListenableFuture<List<WorkInfo>>
//
//// by tag
//workManager.getWorkInfosByTag("syncTag") // ListenableFuture<List<WorkInfo>
//참고 : https://developer.android.com/topic/libraries/architecture/workmanager/how-to/states-andobservation#periodic_work_states