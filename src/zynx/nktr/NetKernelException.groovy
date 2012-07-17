package zynx.nktr

class NetKernelException extends Exception {

    NetKernelException(String s) {
        super(s)
    }

    NetKernelException(String s, Throwable throwable) {
        super(s, throwable)
    }

    NetKernelException(Throwable throwable) {
        super(throwable)
    }
}
