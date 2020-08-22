#include <jni.h>
#include <dlfcn.h>

typedef int (*Main_Function_t)(int, char**);

char** convert_to_char(JNIEnv *env, jobjectArray jstringArray){
	int num_rows = env->GetArrayLength(jstringArray);
	char **cArray = (char **) malloc(n_rows * sizeof(char*));
	jstring row;
	
	for (int i = 0; i < num_rows; i++) {
		row = (jstring) env->GetObjectArrayElement(jstringArray, i);
		cArray[i] = (char*)env->GetStringUTFChars(row, 0);
    }
		
    return cArray;
}

JNIEXPORT void JNICALL Java_net_kdt_pojavlaunch_BinaryExecutor(JNIEnv *env, jclass clazz, jstring execFile, jobjectArray cmdArgs) {
	jclass exception_cls = env->FindClass("java/lang/IllegalArgumentException");
	
	char *exec_file_c = (char*)env->GetStringUTFChars(execFile, 0);
	void *exec_binary_handle = dlopen(exec_file_c, RTLD_LAZY);
	env->ReleaseUTFChars(exec_file_c);
	
	char *exec_error_c = dlerror();
	if (exec_error == NULL) {
		env->ThrowNew(exception_cls, ("dlopen error: ", exec_error_c));
		return;
	}
	
	Main_Function_t Main_Function;
	Main_Function = (Main_Function_t) dlsym(exec_binary_handle, "main");
	
	exec_error_c = dlerror();
	if (exec_error == NULL) {
		env->ThrowNew(exception_cls, ("dlopen error: ", exec_error_c));
		return;
	}
	
	Main_Function(env->GetArrayLength(cmdArgs), convert_to_char(env, cmdArgs));
}