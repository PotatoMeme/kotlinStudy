package com.potatomeme.inflearnKotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

// 코루틴이 어떻게 동작을 하는지

//Like the dream code
//fun main(): Unit {
//    GlobalScope.launch {
//        //label1
//        val userData = fetchUserData()
//        //label2
//        val userCache = cachUserData(userData)
//        //label3
//        updateTextView(userCache)
//    }
//}
//
//suspend fun fetchUserData() = "user_name"
//
//suspend fun cachUserData(user: String) = user
//
//suspend fun updateTextView(user:String) = user


//--------------------------------------------------------------------------------------------------------

//There is no magic
//CPS == Callbacks
//CPS Transformation
//
//Decompile
//Labels
//Callback
//
//CPS simulation
//debugging

//--------------------------------------------------------------------------------------------------------

//package com.potatomeme.inflearnKotlin.coroutines;
//
//import kotlin.Metadata;
//import kotlin.ResultKt;
//import kotlin.Unit;
//import kotlin.coroutines.Continuation;
//import kotlin.coroutines.CoroutineContext;
//import kotlin.coroutines.intrinsics.IntrinsicsKt;
//import kotlin.jvm.functions.Function2;
//import kotlin.jvm.internal.Intrinsics;
//import kotlinx.coroutines.BuildersKt;
//import kotlinx.coroutines.CoroutineScope;
//import kotlinx.coroutines.CoroutineStart;
//import kotlinx.coroutines.GlobalScope;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//@Metadata(
//   mv = {1, 7, 1},
//   k = 2,
//   d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0019\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"},
//   d2 = {"cachUserData", "", "user", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUserData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "main", "", "updateTextView", "app_debug"}
//)
//public final class Step5Kt {
//   public static final void main() {
//      BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2((Continuation)null) {
//         int label;
//
//         @Nullable
//         public final Object invokeSuspend(@NotNull Object $result) {
//            Object var10000;
//            Object var4;
//            label25: {
//               var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
//               switch(this.label) {
//               case 0:
//                  ResultKt.throwOnFailure($result);
//                  this.label = 1;
//                  var10000 = Step5Kt.fetchUserData(this);
//                  if (var10000 == var4) {
//                     return var4;
//                  }
//                  break;
//               case 1:
//                  ResultKt.throwOnFailure($result);
//                  var10000 = $result;
//                  break;
//               case 2:
//                  ResultKt.throwOnFailure($result);
//                  var10000 = $result;
//                  break label25;
//               case 3:
//                  ResultKt.throwOnFailure($result);
//                  return Unit.INSTANCE;
//               default:
//                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
//               }
//
//               String userData = (String)var10000;
//               this.label = 2;
//               var10000 = Step5Kt.cachUserData(userData, this);
//               if (var10000 == var4) {
//                  return var4;
//               }
//            }
//
//            String userCache = (String)var10000;
//            this.label = 3;
//            if (Step5Kt.updateTextView(userCache, this) == var4) {
//               return var4;
//            } else {
//               return Unit.INSTANCE;
//            }
//         }
//
//         @NotNull
//         public final Continuation create(@Nullable Object value, @NotNull Continuation completion) {
//            Intrinsics.checkNotNullParameter(completion, "completion");
//            Function2 var3 = new <anonymous constructor>(completion);
//            return var3;
//         }
//
//         public final Object invoke(Object var1, Object var2) {
//            return ((<undefinedtype>)this.create(var1, (Continuation)var2)).invokeSuspend(Unit.INSTANCE);
//         }
//      }), 3, (Object)null);
//   }
//
//   // $FF: synthetic method
//   public static void main(String[] var0) {
//      main();
//   }
//
//   @Nullable
//   public static final Object fetchUserData(@NotNull Continuation $completion) {
//      return "user_name";
//   }
//
//   @Nullable
//   public static final Object cachUserData(@NotNull String user, @NotNull Continuation $completion) {
//      return user;
//   }
//
//   @Nullable
//   public static final Object updateTextView(@NotNull String user, @NotNull Continuation $completion) {
//      return user;
//   }
//}

//--------------------------------------------------------------------------------------------------------

fun main() {
    println("[in] main")
    myCoroutine(MyContinuation())
    println("\n[out] main")
}

fun myCoroutine(cont: MyContinuation) {
    when(cont.label) {
        0 -> {
            println("\nmyCoroutine(), label: ${cont.label}")
            cont.label = 1
            fetchUserData(cont)
        }
        1 -> {
            println("\nmyCoroutine(), label: ${cont.label}")
            val userData = cont.result
            cont.label = 2
            cacheUserData(userData, cont)
        }
        2 -> {
            println("\nmyCoroutine(), label: ${cont.label}")
            val userCache = cont.result
            updateTextView(userCache)
        }
    }
}

fun fetchUserData(cont: MyContinuation) {
    println("fetchUserData(), called")
    val result = "[서버에서 받은 사용자 정보]"
    println("fetchUserData(), 작업완료: $result")
    cont.resumeWith(Result.success(result))
}

fun cacheUserData(user: String, cont: MyContinuation) {
    println("cacheUserData(), called")
    val result = "[캐쉬함 $user]"
    println("cacheUserData(), 작업완료: $result")
    cont.resumeWith(Result.success(result))
}

fun updateTextView(user: String) {
    println("updateTextView(), called")
    println("updateTextView(), 작업완료: [텍스트 뷰에 출력 $user]")
}

class MyContinuation(override val context: CoroutineContext = EmptyCoroutineContext)
    : Continuation<String> {

    var label = 0
    var result = ""

    override fun resumeWith(result: Result<String>) {
        this.result = result.getOrThrow()
        println("Continuation.resumeWith()")
        myCoroutine(this)
    }
}