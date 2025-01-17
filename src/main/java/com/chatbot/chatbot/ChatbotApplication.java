package com.chatbot.chatbot;


import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

@SpringBootApplication

public class ChatbotApplication implements CommandLineRunner {
    private final VectorStore vectorStore;

    public ChatbotApplication(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public static void main(String[] args) {
        SpringApplication.run(ChatbotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Document> documents = List.of(
                // Sección A: Sobre los Préstamos
                new Document("¿Qué requisitos debo cumplir para solicitar un préstamo?",
                        Map.of("answer", "Debes ser mayor de edad, tener un documento de identidad válido, una cuenta bancaria activa y cumplir con los requisitos de ingresos mínimos establecidos por la plataforma.",
                                "meta", "Sección A - Préstamos")),
                new Document("¿Cuánto dinero puedo solicitar como préstamo mínimo y máximo?",
                        Map.of("answer", "El monto mínimo es de $X (varía según el país) y el máximo dependerá de tu capacidad crediticia y los análisis de riesgo realizados.",
                                "meta", "Sección A - Préstamos")),
                new Document("¿Cuáles son las tasas de interés aplicables?",
                        Map.of("answer", "Las tasas de interés varían según el monto, el plazo y el perfil crediticio del solicitante. Estas serán informadas al momento de completar la solicitud.",
                                "meta", "Sección A - Préstamos")),
                new Document("¿Qué plazos de pago están disponibles para los préstamos?",
                        Map.of("answer", "Los plazos de pago para los préstamos disponibles van desde 6 hasta 180 meses, con diferentes tasas de interés asociadas a cada plazo.",
                                "meta", "Sección A - Préstamos")),
                new Document("¿Puedo adelantar el pago de mis cuotas?",
                        Map.of("answer", "Sí, puedes adelantar pagos parciales o totales sin penalización en la mayoría de los casos. Verifica las condiciones específicas en tu contrato.",
                                "meta", "Sección A - Préstamos")),
                new Document("¿Qué pasa si no puedo pagar una cuota a tiempo?",
                        Map.of("answer", "Se aplicará una penalización por mora, y se notificará al prestatario para regularizar la deuda. Si no se realiza el pago, podría afectar tu historial crediticio.",
                                "meta", "Sección A - Préstamos")),
                new Document("¿Cuánto tiempo tarda en aprobarse un préstamo?",
                        Map.of("answer", "Generalmente, el proceso de aprobación toma entre 24 y 72 horas después de completar la solicitud y enviar los documentos necesarios.",
                                "meta", "Sección A - Préstamos")),
                new Document("¿Necesito tener un garante para solicitar un préstamo?",
                        Map.of("answer", "Dependerá de tu perfil crediticio. En algunos casos, puede ser requerido un garante como respaldo.",
                                "meta", "Sección A - Préstamos")),
                new Document("¿Qué documentos debo presentar para validar mi identidad?",
                        Map.of("answer", "Documento de identidad oficial, comprobante de domicilio y, en algunos casos, comprobantes de ingresos o estado de cuenta bancario.",
                                "meta", "Sección A - Préstamos")),
                new Document("¿Cómo sé si mi solicitud fue rechazada o aprobada?",
                        Map.of("answer", "Recibirás una notificación por correo electrónico o dentro de la plataforma con el estado de tu solicitud y las razones si fue rechazada.",
                                "meta", "Sección A - Préstamos")),

                // Sección B: Sobre la Plataforma y Seguridad
                new Document("¿Cómo se garantiza la seguridad de mis datos personales?",
                        Map.of("answer", "Utilizamos tecnología de encriptación de datos y cumplimos con normativas internacionales de protección de datos personales.",
                                "meta", "Sección B - Plataforma y Seguridad")),
                new Document("¿Quién tiene acceso a mi información en la plataforma?",
                        Map.of("answer", "Solo el personal autorizado y los sistemas automatizados necesarios para procesar tu solicitud tienen acceso a tu información.",
                                "meta", "Sección B - Plataforma y Seguridad")),
                new Document("¿Qué tan confiable es la API de validación de identidad utilizada?",
                        Map.of("answer", "La API utilizada cumple con altos estándares de seguridad y es auditada regularmente para garantizar su confiabilidad.",
                                "meta", "Sección B - Plataforma y Seguridad")),
                new Document("¿Puedo modificar mis datos una vez ingresados?",
                        Map.of("answer", "Sí, puedes actualizar tu información personal desde tu perfil, siempre que no haya una solicitud pendiente de aprobación.",
                                "meta", "Sección B - Plataforma y Seguridad")),
                new Document("¿Qué hago si olvidé mi contraseña?",
                        Map.of("answer", "Puedes restablecerla desde la opción “Olvidé mi contraseña” en la página de inicio de sesión. Recibirás un enlace en tu correo.",
                                "meta", "Sección B - Plataforma y Seguridad")),
                new Document("¿Cómo recupero mi acceso si se bloquea mi cuenta?",
                        Map.of("answer", "Contacta al equipo de soporte desde el formulario en la plataforma para desbloquear tu cuenta.",
                                "meta", "Sección D - Soporte y Acceso")),
                new Document("¿Puedo usar la plataforma desde cualquier país de Latinoamérica?",
                        Map.of("answer", "Actualmente está disponible en países específicos de la región. Verifica si tu país está en la lista al registrarte.",
                                "meta", "Sección D - Soporte y Acceso")),
                new Document("¿Qué medidas toman contra fraudes o identidades falsas?",
                        Map.of("answer", "Implementamos validación de documentos, análisis biométrico y monitoreo de actividad sospechosa en la plataforma.",
                                "meta", "Sección D - Soporte y Acceso")),

                // Sección C: Sobre la Inversión
                new Document("¿Cómo funciona el modelo de inversión en préstamos?",
                        Map.of("answer", "Los inversores financian préstamos aprobados y reciben intereses sobre el dinero prestado según los términos acordados.",
                                "meta", "Sección C - Inversión")),
                new Document("¿Qué garantías tienen los inversores sobre los préstamos otorgados?",
                        Map.of("answer", "Los préstamos están respaldados por análisis de riesgo, y algunos pueden incluir garantías adicionales dependiendo del perfil del prestatario.",
                                "meta", "Sección C - Inversión")),
                new Document("¿Cuáles son las métricas clave para evaluar las inversiones?",
                        Map.of("answer", "Indicadores como la tasa de interés, el historial crediticio del prestatario y el plazo del préstamo son esenciales.",
                                "meta", "Sección C - Inversión")),
                new Document("¿Qué tipo de rendimiento puedo esperar?",
                        Map.of("answer", "Los rendimientos varían entre X% y Y% anual, dependiendo de los riesgos asociados a los préstamos seleccionados.",
                                "meta", "Sección C - Inversión")),
                new Document("¿Cómo retiro las ganancias obtenidas de mi inversión?",
                        Map.of("answer", "Las ganancias se depositan en tu cuenta de usuario y puedes transferirlas a tu cuenta bancaria registrada.",
                                "meta", "Sección C - Inversión")),
                new Document("¿Puedo diversificar mi inversión en distintos préstamos?",
                        Map.of("answer", "Sí, puedes asignar tu capital a múltiples préstamos para reducir el riesgo.",
                                "meta", "Sección C - Inversión")),
                new Document("¿Qué información del prestatario será visible para mí como inversor?",
                        Map.of("answer", "Solo datos relevantes como el puntaje crediticio, monto solicitado y plazo, manteniendo la privacidad del prestatario.",
                                "meta", "Sección C - Inversión")),

                // Sección D: Sobre el Proceso y Soporte
                new Document("¿Cuánto tiempo tarda la verificación de identidad?",
                        Map.of("answer", "En promedio, la verificación se realiza en menos de 24 horas.",
                                "meta", "Sección D - Proceso y Soporte")),
                new Document("¿Qué hago si el sistema rechaza mis documentos?",
                        Map.of("answer", "Revisa las instrucciones de carga y asegúrate de que los documentos sean claros y estén actualizados.",
                                "meta", "Sección D - Proceso y Soporte")),
                new Document("¿Puedo cancelar mi solicitud de préstamo después de iniciarla?",
                        Map.of("answer", "Sí, mientras no haya sido aprobada. Una vez aprobada, se aplican las condiciones del contrato.",
                                "meta", "Sección D - Proceso y Soporte")),
                new Document("¿Cómo contacto al soporte técnico si tengo problemas?",
                        Map.of("answer", "Desde la sección de Ayuda o mediante correo electrónico. Responderemos en un plazo de 24-48 horas.",
                                "meta", "Sección D - Proceso y Soporte")),
                new Document("¿Qué hago si detecto una transacción no autorizada en mi cuenta?",
                        Map.of("answer", "Notifica inmediatamente al soporte técnico para bloquear tu cuenta y realizar las investigaciones necesarias.",
                                "meta", "Sección D - Proceso y Soporte")),
                // Sección E: Sobre Condiciones y Políticas
                new Document("¿Cuáles son las políticas de privacidad de la plataforma?",
                        Map.of("answer", "Puedes consultarlas en el apartado 'Política de Privacidad' del sitio web.",
                                "meta", "Sección E - Condiciones y Políticas")),
                new Document("¿Qué pasa si entro en mora por más de tres meses?",
                        Map.of("answer", "La deuda será enviada a una agencia de cobranzas y podría afectar tu historial crediticio.",
                                "meta", "Sección E - Condiciones y Políticas")),
                new Document("¿La plataforma cobra algún costo adicional o comisiones?",
                        Map.of("answer", "Sí, se aplican comisiones por apertura de préstamos o gestión de inversiones, que son informadas previamente.",
                                "meta", "Sección E - Condiciones y Políticas")),
                new Document("¿Qué sucede si quiero cerrar mi cuenta?",
                        Map.of("answer", "Puedes solicitarlo desde el menú de configuración, siempre que no tengas deudas activas.",
                                "meta", "Sección E - Condiciones y Políticas")),
                new Document("¿Es posible refinanciar un préstamo?",
                        Map.of("answer", "Sí, dependiendo de tu historial de pagos y perfil crediticio.",
                                "meta", "Sección E - Condiciones y Políticas")),
                new Document("¿Qué tipo de contrato firmo al aceptar un préstamo o invertir?",
                        Map.of("answer", "Firmas un contrato digital que detalla las condiciones específicas del préstamo o inversión.",
                                "meta", "Sección E - Condiciones y Políticas")),
                // Sección F: Generalidades
                new Document("¿La plataforma tiene una aplicación móvil?",
                        Map.of("answer", "Sí, está disponible para dispositivos Android e iOS.",
                                "meta", "Sección F - Generalidades")),
                new Document("¿Cómo me notifican sobre los pagos de mis cuotas?",
                        Map.of("answer", "A través de notificaciones en la app, correos electrónicos y recordatorios en tu perfil.",
                                "meta", "Sección F - Generalidades")),
                new Document("¿Qué hago si tengo dudas durante la solicitud?",
                        Map.of("answer", "Consulta las guías en la sección de Ayuda o contacta al soporte técnico.",
                                "meta", "Sección F - Generalidades")),
                new Document("¿Qué sucede si quiero aumentar el monto de mi préstamo una vez aprobado?",
                        Map.of("answer", "Deberás iniciar una nueva solicitud para evaluar tu capacidad de crédito.",
                                "meta", "Sección F - Generalidades")),
                new Document("¿Puedo recomendar la plataforma a otras personas y recibir algún beneficio?",
                        Map.of("answer", "Sí, contamos con un programa de referidos que otorga beneficios a quienes inviten usuarios exitosos.",
                                "meta", "Sección F - Generalidades")),
                new Document("¿Es necesario un correo electrónico para registrarme?",
                        Map.of("answer", "Sí, es un requisito obligatorio para validar tu cuenta.",
                                "meta", "Sección F - Generalidades")),
                new Document("¿Puedo acceder a la plataforma en otros idiomas?",
                        Map.of("answer", "Actualmente está disponible en español y próximamente en inglés y portugués.",
                                "meta", "Sección F - Generalidades")),
                new Document("¿Qué pasa si no tengo un historial crediticio?",
                        Map.of("answer", "Podrás iniciar con préstamos pequeños que ayuden a construir tu historial.",
                                "meta", "Sección F - Generalidades")),
                new Document("¿Cómo se maneja la relación entre inversores y prestatarios?",
                        Map.of("answer", "Es gestionada por la plataforma, asegurando la privacidad y cumplimiento de los términos.",
                                "meta", "Sección F - Generalidades")),
                // Sección G: Casos Específicos
                new Document("¿Puedo solicitar más de un préstamo al mismo tiempo?",
                        Map.of("answer", "Depende de tu historial de pagos y análisis de capacidad de endeudamiento.",
                                "meta", "Sección G - Casos Específicos")),
                new Document("¿Qué hago si el monto solicitado no cubre mis necesidades?",
                        Map.of("answer", "Puedes solicitar un ajuste o iniciar una nueva solicitud con un monto mayor.",
                                "meta", "Sección G - Casos Específicos")),
                new Document("¿Cómo me aseguro de que mi inversión tenga bajos riesgos?",
                        Map.of("answer", "Analiza el puntaje crediticio del prestatario y diversifica tus inversiones.",
                                "meta", "Sección G - Casos Específicos")),
                new Document("¿Qué sucede si quiero cambiar a mi garante después de enviar los datos?",
                        Map.of("answer", "Deberás presentar los datos del nuevo garante para una reevaluación del préstamo.",
                                "meta", "Sección G - Casos Específicos")),
                new Document("¿Cómo se gestiona la conversión de divisas si el préstamo es internacional?",
                        Map.of("answer", "La plataforma realiza la conversión automática según el tipo de cambio actual.",
                                "meta", "Sección G - Casos Específicos")),
                // Sección H: Preguntas ambiguas o incoherentes
                new Document("¿Por qué el cielo es azul?",
                        Map.of("answer", "Esta plataforma está diseñada para resolver dudas relacionadas con préstamos e inversiones. Reformula tu pregunta para que podamos ayudarte de manera más precisa.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("asdfghjkl?",
                        Map.of("answer", "No podemos identificar tu consulta. Por favor, verifica la pregunta y vuelve a intentarlo.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("123456789?",
                        Map.of("answer", "Parece que ingresaste caracteres sin contexto. Reformula tu consulta para poder asistirte de forma adecuada.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("Lorem ipsum dolor sit amet?",
                        Map.of("answer", "El texto ingresado parece un ejemplo genérico. Por favor, formula una consulta relacionada con préstamos o inversiones.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("🤔🤔🤔?",
                        Map.of("answer", "No entendemos tu consulta. Por favor, sé más claro para que podamos ofrecerte la asistencia necesaria.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                // Preguntas filosóficas o absurdas
                new Document("¿Qué fue primero, el huevo o la gallina?",
                        Map.of("answer", "Nuestra plataforma no aborda preguntas filosóficas. Por favor, plantea una consulta específica sobre nuestros servicios financieros.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("¿Puedes prestarme felicidad?",
                        Map.of("answer", "Estamos aquí para ayudarte con préstamos financieros. Reformula tu pregunta para que podamos brindarte una respuesta adecuada.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("¿Cómo puedo volar?",
                        Map.of("answer", "Entendemos que puedas tener dudas, pero nuestras respuestas están limitadas a préstamos e inversiones. Reformula tu consulta para que podamos asistirte.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("¿Dónde está el unicornio?",
                        Map.of("answer", "No podemos ayudarte a encontrar un unicornio, pero sí a resolver tus dudas sobre préstamos e inversiones. Reformula tu consulta.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("¿Qué hago si quiero hablar con aliens?",
                        Map.of("answer", "Nuestra plataforma no tiene información sobre aliens. Si tienes dudas sobre préstamos o inversiones, estamos para ayudarte.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                // Insultos o lenguaje inapropiado
                new Document("Esto es una estafa.",
                        Map.of("answer", "Entendemos tus preocupaciones. Te aseguramos que cumplimos con todas las normativas legales y garantizamos transparencia en todos nuestros procesos. Si tienes dudas, contáctanos para resolverlas.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("¡Son unos ladrones!",
                        Map.of("answer", "Lamentamos que tengas esa impresión. Por favor, contáctanos para aclarar cualquier malentendido o problema que hayas experimentado.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("Esto es una basura.",
                        Map.of("answer", "Apreciamos tus comentarios y nos gustaría mejorar tu experiencia. Por favor, detalla tus inquietudes para que podamos ayudarte de manera efectiva.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("Son inútiles.",
                        Map.of("answer", "Lamentamos que te sientas así. Estamos aquí para ayudarte y resolver cualquier inconveniente con nuestros servicios.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                // Lenguaje ofensivo
                new Document("¡%&@*!",
                        Map.of("answer", "Tu mensaje contiene lenguaje ofensivo. Por favor, mantén un tono respetuoso para que podamos asistirte adecuadamente.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("Esto es una mierda.",
                        Map.of("answer", "Entendemos tu frustración y estamos aquí para ayudarte. Reformula tu consulta para que podamos asistirte de forma efectiva.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("¡Malditos sean!",
                        Map.of("answer", "Lamentamos que te sientas así. Estamos comprometidos en ofrecerte el mejor servicio posible. Si tienes un problema específico, contáctanos.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                // Casos ambiguos o irrelevantes
                new Document("¿Cómo está el clima hoy?",
                        Map.of("answer", "Nuestra plataforma no ofrece información meteorológica. Por favor, plantea una consulta relacionada con préstamos o inversiones.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("¿Me puedes dar un número de lotería?",
                        Map.of("answer", "No proporcionamos números de lotería, pero sí asistencia con préstamos e inversiones. Reformula tu pregunta para recibir ayuda.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),

                new Document("¿Qué opinas del fútbol?",
                        Map.of("answer", "Aunque el fútbol es un tema interesante, nuestras respuestas están orientadas a servicios financieros. Por favor, plantea una consulta relevante.",
                                "meta", "Sección H - Casos de preguntas sin sentido")),
                new Document("¿Cómo iniciar una solicitud de préstamo?",
                        Map.of("answer",
                                """ 
        1. Ingresa el monto a solicitar.
        2. Elige una opción de cuota con su tasa de interés.
        3. Asegúrate de que tu sueldo sea al menos 3 veces el monto de la cuota.
        4. Si estás conforme con las condiciones, confirma la solicitud.
        5. Completa los datos necesarios y espera la notificación de la aprobación.
        """,
                                "meta", "Sección H - Cómo iniciar una solicitud de préstamo")
                )
        );

        vectorStore.add(documents);
    }
}
