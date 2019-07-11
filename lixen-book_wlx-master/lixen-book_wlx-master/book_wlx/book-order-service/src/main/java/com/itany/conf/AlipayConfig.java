package com.itany.conf;

import com.alipay.api.DefaultAlipayClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayConfig {

//     @Bean(name="alipayClient")
//    public DefaultAlipayClient alipayClient(){
//         DefaultAlipayClient alipayClient =
//                 new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do"
//                 ,"2016092600600256"
//                 ,"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCeUF5VJl+kyJtD5UGY3o9mSS3yMYJ9kIYCDFa/naa7WkMkkF9x4nqHvt4IIP/7I88HUtH2JojMpnIPKCdN1vmR+wEOVd+4SzXu24hOmSjbW7bGPjvyaitG/vUaTMGrMH7GDSdq1Hp4hmekp0AIO8a1M57EIPTdpusJ3meXnSco5KmtERXf+gA2q5snYNcecVy91aKg3Jt3/wouMySJV42gfhIe/H0M+xegxFqvd7CHM1EkMRIxpzIwI0NSfyoSB78P7dRk4vhtRpI2yhFB2EuY2rQnDVViGVzl7ZxtOVX5HU7OchLRx1yKntmgWg5hvwAqMctatLBAGlssX9esIKOtAgMBAAECggEAQ4Ht1813N2M7oiYeZLty1qEZ8I7gH/8CxdjRHQBy2q1QuETADmYO7decAkdgII1SeML+OUKRTwMi3Ae5St4Cqhcoih5gOcwIgYQniayR2YgwVjSvh11yeuG5Tq+wXfld9cIiLtHQL5jQlUukaF5lC1upteR/xgypaRnnfqVKz4qV7yfccn/mtnqyMwLKFDEuinipUnbggTx2vBB+qrb68MjHRpQ+P2tJQCph7k37fFWaNv9nHwwdGHYU0XQgvh7dB+/922KO1HgXPUcwyP0yWTS1Ib3tzepK5Mc9nkuBKD8TgjlYUc45yEDqBiSaJw12eNEHO2GzJx5Z6FuhszHYQQKBgQDawKdiCCexBR1sdilLseT0Kry/8UEzusMAGQkvsm4sJkpEPdWewSEGtuNWiIv9602bLjjOtaCzmgiRoCn+2Wd8XBckg38H0Wn/nXAYEkgVOdy115u+NmZ20MK8mTWbqDS2U2ZHC7MVGl5uij8IgdubfrDeSk2Km6IASOcnJJEqKQKBgQC5RTeGWTz7UPs9yp6EaphKyaoi+4cUDDB6pHEJDgr8F0DBs67zE1E9BHKmO2eIFTpGlOiLBieeHJHqcO+rHj9QN1HFDAUI7gXoWOmSu5wNyUf9MEnIdKuw8RxE0WvHLgE9W7DhyPy9g2QIKUzfLwU331aj/viXyx0gCOyDw34l5QKBgQDM1JRm8Ofpk7aHduUYIc0W7GWs/QRmobwx/T9i0BrlcD0eRSAf9QsttFaPEnCzJH+YjOFYfS2qvtLDOUvZfEywX7Kz2AU8ltRAK3VotMWWSoXmJ6uHonyzSKrv2i4eQJSLHPCqGcRoQDaoHv8CwkWWBj0rCDwvS6eXyKvZNR5QcQKBgA4wQddVIDly8zrBOLCVZUJc/V2ee7LKWDAcRdfWrnqt4TS0aRKOiSsuGwWmCQC/922OW9zBxOjz8SzOJ1yofVrMUcPQbtZHPEaWAJVPLt1Ta+L0/sGORdPQM0UF8MYZPNkRG5O/C7QLyu5hE1UISdMElKMMlMczM/DPHiXdI90NAoGAfRrAN3MizYKcS+54eMFwTeU2/6d3DjJ0d/PKFYLjclgAdAhpmdic4zH/E1U+HMHO1EELpLf4MMceV6pHDs9iu8svdJhKH5Hqx90PydFQES/uFwi7SLMVvEVFoIXZngVwlfXccsZk/IkeAji2JY4XYDVHX+4cFjB1eKvWg4jnr+U="
//                 ,"json"
//                 ,"utf-8"
//                 ,"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApaP14sbW2b/oNEsY3Xi8rvFbfdxMlSwqV0Y2N9QO9IEoBfc1haW/H3dOjgjj8fiwo+vmN0ZtYVFJSzbsBDNiFoJK7YcavaP/aD26xHEuFIO28k0AszUhUvoOxdsefZc1aJI++N5H+5Th3UqnnKOKLAKXIVIw7y7db2+zodf8mSLakV1sxt7nLk4/OSGk0XHF8Fp7wV2TGeGyFXm1Icil3ONn9+AzJXJWkGDooCZROpIpyolJEar6DGe4QuQol95wHGi02330zuPZ6N1KNVShdZnmmrfMIznML3peCUWURcDYUQIJ3jJj3wmz1TuQLfxhB3U64OSYYsIipPUyGVFdiQIDAQAB"
//                 ,"RSA2");
//         return alipayClient;
//    }
    @Bean(name="alipayClient")
    public DefaultAlipayClient alipayClient(){
        DefaultAlipayClient alipayClient =
                new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do"
                        ,"2016091100489179"
                        ,"MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC1R7h+rYVW3xRNbgJ3cDtK0zx4AiHBa/s+DwD0i4Dqkv5MkaPUdydutbV4+n9IX5HkTrP3znW4XemQNtH5BxeqRaz/iXDyOJtuYbBrq+mUTPyWW5An1Pc6qZVdJV0XJhQ5CWsI0wk9U6HVjP2cU3aYYlJNvWq4IqZxMA8GRs6EEfrCK/JnlZMBiXj3fNulgxCUfk+HYPU4dfSIKSwVYVCw9oIFCC8PjWXahrGnLRSB3fbx7wCBslxH+im8s+CtNsg5e0Pwnvgeekh2z8gTErx6Ou05fKx7RDd9PRNF2iP4BFNITwPw2/AZRXici9NJwR++8xnOFGsfzGiL/z/YP8u7AgMBAAECggEAX+tMJtM/y4CMKJA+A97BsMzmoQVXwRWWwfaEZeDu3K/cmL0zN7e4iK7jD9lTwgK3mls+hK+cwGoIrMMlBSSIlBL7/9ZEihYDwDs2czJqjIrT1+co9rqL+mFC5B9iC16dsrRWCzxHFkkLR4irpKzRAr57mCDSuA21jgyE1qhem6hXdGPo9YxIloJZ3Wp3qt8dK7ZxJU3XYvp+TtA6yG4wp/KSj1+/+K3W7wPzsPJDwh9yCXSYw9B4k0xCHPKLqsM8yCDfxA7a3CmAqQSWxgUVv9U7dZnrT0ZYdgH3HOyJh1lWaWDSqPVzzFzoZNRRgJhUK7iu6jwYv7nmEG9yCZzXUQKBgQDj/C+pCnfK3EL5xHlFChYFmbnii3W4O6cJQeGOzUfHWriIAFLMhkbHCtet+NQkgsRJRJNfx8/FxdrkhpPKbNJIpfWAkyTJ3pIkXi12gGWZuOdlh++78VtlkZMSnG4FIwM+J87izWrZujte/UeV8HcJXiGxqWQuatZIjcoi6JZniQKBgQDLjlHD1al4iuUPnaSmW9P7o+LyF0NyE2gfym+OZNFKoS/KkItAO/+F7wAtxr0+mgEHAVA+Fi2mQbY5Er5zL70Ri8nM3eeRBrZqE+KkpnCpJTA3wgwliwMRAhEJvjTYTwWSozJxqt0q8KUeKgz61XhiX1XQJ56BM8WSh1jJ66WEIwKBgGouWxg0uuQtP7hKLFzePLFxDmUXpMUga0Rhfabfrs2HUChvViDRbQdo4lixakRy7u5c1PKoAfnPk4oZr514n1uch8HRRjIKyi/L+QqW9DrrJkJgVGRJHdMpQMFLP+Z+jxUUv0NcfqZXGS29cui/bQFc6P5wsSr5MUHrX7hwcRRZAoGAG2EOMGgZvmP4QWxzzAiH783wZZ2pbbucgsIo1R9MY1xg4D8m68HmMa6e+IlFxRjT0IxlraQwCa/HAdA6m6WtKaICx7KFRiV//a6lCn50otukq6tHFPmotO3xOr1BwGKInlujGlTgILlzjCYdztNNuPWXxkK9+CTtizL3R1mRzr8CgYB872rFiTEVH0I7mEoEKkxn20ItziaxoBSiiPmRIhJbHaDwaITk7bqDRATaF4I5WIFQQdWDPHOHBBn3ZKrQM245BxjJR7tnzXXyBlhNNtMWJaW9zfey+ZXybcZOEBg4RzGbzdeSmWErSkZZqVXHyTIelWiLW3hhsOHJRb2kCND/Dw=="
                        ,"json"
                        ,"utf-8"
                        ,"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx7k9t3V8ShvDBffY+SIM2yBRM4GXrK5TGQRWJKLxNAaVuMLWDGLHtQdXKCRJX9S/BzMjXd3xG8aWD28TEylFwKkcODuaGpG1N2sMbA46N3xgutWMDj2H2uipCS5d1ayJY7rwH9PD8OHHlWu4Q28OpMERGLQTkPIX7xtAgSwyhOVAGx6wlLZT+MvVkPYf1qi8TMnwnf6gEuD+7LP9/TcCdVn3GH8pF4ZbiviOyE08xTxzNEsr7/ROAWmq3svoAoXq2zt6Nhn7bJsmAm4TRHCH+TvXkRGpLh8XTFtn01xKG8yAC3ShL7bA0jWxRyKdpsfrFMnvF42zoiLS3rIKHxEoUwIDAQAB"
                        ,"RSA2");
        return alipayClient;
    }

}
